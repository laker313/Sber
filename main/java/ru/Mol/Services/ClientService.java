package ru.Mol.Services;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.Mol.DataCSVClasses.ClientDBData;
import ru.Mol.DataJSONClases.JsonMapper;
import ru.Mol.Enum.RequestCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;


@Service
public class ClientService {

     public ResponseEntity saveClient(String jsonClient){
         ObjectMapper mapper = new ObjectMapper();
         mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
         try{
             JsonMapper jsonMapper=mapper.readValue(jsonClient, JsonMapper.class);
             File file = new File("C:\\FileForDB\\clientFile.csv");
             FileWriter writer = new FileWriter(file,true);
             ClientDBData clientDBData = new ClientDBData(jsonMapper);
             writer.append(clientDBData.convertToCSV());
             writer.append("\n");
             writer.close();
         }catch ( JsonProcessingException e){
             System.out.println(e.getMessage());
             return  new ResponseEntity(RequestCode.JSONINCORRECT.getResponseText(),HttpStatus.INTERNAL_SERVER_ERROR);
         }catch (FileNotFoundException e) {
             return  new ResponseEntity(RequestCode.CLIENTISNOTSAVED.getResponseText(),HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (IOException e){
             return  new ResponseEntity(RequestCode.CLIENTISNOTSAVED.getResponseText(),HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception e){
             return  new ResponseEntity(RequestCode.UNEXPECTEDERROR.getResponseText(),HttpStatus.INTERNAL_SERVER_ERROR);
         }

             return new ResponseEntity(RequestCode.OK.getResponseText(),HttpStatus.OK);
    }
}
