package sensor;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class SensorController {

	final Map<String, List<Measurement>> measurementsMap= new HashMap<String,List<Measurement>>();
	List measurements = new ArrayList<Measurement>();
	@RequestMapping("/sensors")
   public ResponseEntity<Map<String,List<Measurement>>> sensor() {

    	
    	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    	
    	return new ResponseEntity<Map<String,List<Measurement>>>(measurementsMap, HttpStatus.OK);
    	//return sensorMap;
    	
    }
   @RequestMapping(value = "/sensors", method = RequestMethod.POST)
   public ResponseEntity<Measurement> update(@RequestBody Measurement measurement) {
	
	measurements.add(measurement);	   
	measurementsMap.put("measurements", measurements);   
	   
   	return new ResponseEntity<Measurement>(measurement, HttpStatus.OK);
       
   }


}
