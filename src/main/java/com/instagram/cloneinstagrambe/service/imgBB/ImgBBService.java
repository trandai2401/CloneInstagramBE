package com.instagram.cloneinstagrambe.service.imgBB;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.instagram.cloneinstagrambe.dto.imgBB.ResponseImgBB;
import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@Service
public class ImgBBService  implements IImgBBService{
    static final String KEY = "a57fc02e85ffcaf0c054a9aeaf39bb36";
    static final String URL = "https://api.imgbb.com/1/upload/";

    @Override
    public ResponseImgBB save(MultipartFile file) throws IOException {
//        byte []b = file.getBytes();
        String s = Base64.getEncoder().encodeToString(file.getBytes());

        return  callApi(s);
    }

    private ResponseImgBB callApi(String image) throws ClientProtocolException, IOException {

        HttpResponse httpResponse = Request.Post("https://api.imgbb.com/1/upload")
                .bodyForm(Form.form().add("key", "a57fc02e85ffcaf0c054a9aeaf39bb36").add("image", image).build())
                .execute().returnResponse();

        System.out.println("Protocol: " + httpResponse.getProtocolVersion());
        System.out.println("Status:" + httpResponse.getStatusLine().toString());
        System.out.println("Content type:" + httpResponse.getEntity().getContentType());
        System.out.println("Locale:" + httpResponse.getLocale());
        System.out.println("Headers:");
        for(Header header : httpResponse.getAllHeaders()) {
            System.out.println("          " + header.getName()+": " + header.getValue());
        }
        System.out.println("Content:");
        String content = IOUtils.toString(httpResponse.getEntity().getContent(), "UTF-8");
//	    String content = response.returnContent().asString();
        ObjectMapper objectMapper = new ObjectMapper();


        ResponseImgBB resp = objectMapper.readValue(content, ResponseImgBB.class);
        System.out.println(resp);
return resp;

    }
}
