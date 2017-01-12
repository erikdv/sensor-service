package sensor;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class SensorController {

	final Map<String, List<Measurement>> measurementsMapOut= new HashMap<String,List<Measurement>>();
	
	@RequestMapping("/sensors")
   public ResponseEntity<Map<String,List<Measurement>>> sensor() {
    	
    	return new ResponseEntity<Map<String,List<Measurement>>>(measurementsMapOut, HttpStatus.OK);
    	//return sensorMap;
    	
    }
	
   @RequestMapping(value = "/sensors", method = RequestMethod.POST)
   public ResponseEntity<Map<String, Measurement>> update(@RequestBody Map<String, Measurement> measurementMapIn) {
	
	   Map.Entry<String, Measurement> entry = measurementMapIn.entrySet().iterator().next();
	  
	   if (measurementsMapOut.get(entry.getKey()) == null) {
		   List measurements = new ArrayList<Measurement>();
		   measurements.add(entry.getValue());
		   measurementsMapOut.put(entry.getKey(), (List<Measurement>) measurements);
		  
	   }
	   else {

		   measurementsMapOut.get(entry.getKey()).add(entry.getValue());
	   
	   }
//	for (Entry<String, Measurement> entry : measurementMapIn.entrySet()) {
//		
//		measurements.add(entry.getValue());
//		measurementsMapOut.put(entry.getKey(), (List<Measurement>) measurements);
//	}
	   
   	return new ResponseEntity<Map<String, Measurement>>(measurementMapIn, HttpStatus.OK);
       
   }

   
}
