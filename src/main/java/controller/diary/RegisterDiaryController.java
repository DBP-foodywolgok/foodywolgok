package controller.diary;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.customer.UserSessionUtils;
import model.Diary;
import model.dao.DiaryDAO;


public class RegisterDiaryController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(RegisterDiaryController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
        // customerId 
        HttpSession session = request.getSession();
        int customerId = (int) session.getAttribute(UserSessionUtils.USER_SESSION_KEY);
        
        //각 item 
        String title = null;
    	int isShared = 0;
    	String content = null;    	    	
    	String filename = null;    	
    	String place=null;
    	
    	boolean check = ServletFileUpload.isMultipartContent(request);    			
		if(check) {    // 전송된 요청 메시지의 타입이 multipart 인지 여부를 체크한다. (multipart/form-data)
			
			// 아래와 같이 하면 Tomcat 내부에 복사된 프로젝트 밑에 upload 폴더가 생성됨 
			ServletContext context = request.getServletContext();
			String path = context.getRealPath("/upload");
			File dir = new File(path);			
						
			if (!dir.exists()) dir.mkdir();  // 전송된 파일을 저장할 폴더 생성
			
			try {
				DiskFileItemFactory factory = new DiskFileItemFactory();
					// 파일 전송에 대한 기본적인 설정 Factory 클래스를 생성한다.
                factory.setSizeThreshold(10 * 1024);
                	// 메모리에 한번에 저장할 데이터의 크기를 10KB로 설정한다.
                factory.setRepository(dir);
                	// 전송된 데이터의 내용을 저장할 폴더를 지정한다.                
    
                ServletFileUpload upload = new ServletFileUpload(factory);
                	// Factory 클래스를 통해 실제 업로드 되는 내용을 처리할 객체를 선언한다.
                upload.setSizeMax(10 * 1024 * 1024);
                	// 업로드 될 파일의 최대 용량을 10MB로 설정한다.
                upload.setHeaderEncoding("utf-8");
                	// 업로드 되는 내용의 인코딩 방식을 설정한다.
                                
                List<FileItem> items = (List<FileItem>)upload.parseRequest(request);                
                	// upload 객체에 전송된 모든 데이터(요청 파라미터)를 Collection 객체에 담는다.
                
                for (int i = 0; i < items.size(); ++i) {
                	FileItem item = (FileItem)items.get(i);            
                	
                	String value = item.getString("utf-8"); // 넘어온 값에 대한 한글 처리를 한다.               	
                	
                	if (item.isFormField()) {  // item이 일반 데이터인 경우                		
                		if(item.getFieldName().equals("diary_title")) 
                			title = value;
                			// parameter 이름이 name이면 name 변수에 값을 저장한다.
                		else if(item.getFieldName().equals("diary_friend")) 
                			isShared = ( value==null? 0:1 );
                			// parameter 이름이 id이면 id 변수에 값을 저장한다.
                		else if(item.getFieldName().equals("diary_content")) 
                			content = value;
                			// parameter 이름이 pw이면 pw 변수에 값을 저장한다.
                		else if(item.getFieldName().equals("diary_place"))
                			place = value;
                	}
                	else {  // item이 파일인 경우   
                		if (item.getFieldName().equals("diary_picture")) {
                			// parameter 이름이 picture이면 파일 저장을 한다.
                			String oriFilename = item.getName();	// 파일 이름 획득 (자동 한글 처리 됨)
                			if (oriFilename == null || oriFilename.trim().length() == 0) continue;
                				// 파일이 전송되어 오지 않았다면 건너뜀
            				
            				filename = UUID.randomUUID().toString() + "_" 
            						+ oriFilename.substring(oriFilename.lastIndexOf("\\") + 1);  
            					// 파일 이름이 중복되지 않도록 UUID(Universally Unique IDentifier)를 생성해서 원래의 이름 앞에 붙임
            				 
                         	System.out.println("uploaded file: " + filename);
         						
                			File file = new File(dir, filename);
                			item.write(file);
                				// 파일을 upload 경로에 실제로 저장한다.
                				// FileItem 객체로부터 바로 출력 저장할 수 있다.
                		}
                	}
                }
                
			} catch(SizeLimitExceededException e) {
				// 업로드 되는 파일의 크기가 지정된 최대 크기를 초과할 때 발생하는 예외처리
				e.printStackTrace();           
            } catch(FileUploadException e) {
            	// 파일 업로드와 관련되어 발생할 수 있는 예외 처리
                e.printStackTrace();
            } catch(Exception e) {            
                e.printStackTrace();
            }
			
			Diary diary = new Diary();
	    	diary.setTitle(title);
	    	diary.setIsShared(isShared);
	    	diary.setContent(content);
	    	diary.setCustomer_id(customerId);
	    	
	    	diary.setPicture(filename);
	    	diary.setPlace(place);
	    	
	    	DiaryDAO diaryDAO = new DiaryDAO();
	        
	        int result = diaryDAO.create(diary);
	        int diaryId = diary.getDiary_id();
	        
	        diary = null;
	        
	        if (result > 0) {
	        	diary = diaryDAO.findDiary(diaryId);
	        	request.setAttribute("diary", diary);	
	        	return "/DiaryDetail.jsp";
	        }
	        else
	        	return "/RegistrationDiary.jsp";
		}		
        
        return "/RegistrationDiary.jsp";
    }
      
}
