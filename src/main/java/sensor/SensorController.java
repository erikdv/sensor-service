package sensor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SensorController {

    private static final String template = "Hallo, %s!";
    private final AtomicLong counter = new AtomicLong();

   @RequestMapping("/sensors")
   public ResponseEntity<Map<String,List<Sensor>>> sensor(@RequestParam(value="name", defaultValue="World") String name) {

    	final Map<String, List<Sensor>> sensorMap= new HashMap<String,List<Sensor>>();
    	List sensors = new ArrayList<Sensor>();
    	Sensor sensor = new Sensor(3, "Doetut");
    	sensors.add(sensor);
    	sensorMap.put("sensors", sensors);
    	return new ResponseEntity<Map<String,List<Sensor>>>(sensorMap, HttpStatus.OK);
    	//return sensorMap;
    	
    }

}
