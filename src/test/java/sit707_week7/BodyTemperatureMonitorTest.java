package sit707_week7;

import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class BodyTemperatureMonitorTest {

	@Test
	public void testStudentIdentity() {
		String studentId = "223739038";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Muhammad Jahanzaib Khan";
		Assert.assertNotNull("Student name is null", studentName);
	}
	
	@Test
	public void testReadTemperatureNegative() {
        // Stub temperatureSensor to return a negative temperature reading
        TemperatureSensor temperatureSensor = mock(TemperatureSensor.class);
        when(temperatureSensor.readTemperatureValue()).thenReturn(-1.0); // Assuming -1.0 represents a negative reading
        BodyTemperatureMonitor monitor = new BodyTemperatureMonitor(temperatureSensor, null, null);
        
        double temperature = monitor.readTemperature();
        
        Assert.assertTrue("Temperature is not negative", temperature < 0);
    }
	
	@Test
    public void testReadTemperatureZero() {
        // Stub temperatureSensor to return a zero temperature reading
        TemperatureSensor temperatureSensor = mock(TemperatureSensor.class);
        when(temperatureSensor.readTemperatureValue()).thenReturn(0.0);
        BodyTemperatureMonitor monitor = new BodyTemperatureMonitor(temperatureSensor, null, null);
        
        double temperature = monitor.readTemperature();
        
        Assert.assertEquals("Temperature is not zero", 0.0, temperature, 0.01);
    }
	
	@Test
	public void testReadTemperatureNormal() {
        // Stub temperatureSensor to return a normal temperature reading
        TemperatureSensor temperatureSensor = mock(TemperatureSensor.class);
        when(temperatureSensor.readTemperatureValue()).thenReturn(36.7); // Assuming 36.7 represents a normal temperature
        BodyTemperatureMonitor monitor = new BodyTemperatureMonitor(temperatureSensor, null, null);
        
        double temperature = monitor.readTemperature();
        
        Assert.assertTrue("Temperature is not within the normal range", temperature >= 35.0 && temperature <= 37.0);
    }
	
	@Test
	public void testReadTemperatureAbnormallyHigh() {
        // Stub temperatureSensor to return an abnormally high temperature reading
        TemperatureSensor temperatureSensor = mock(TemperatureSensor.class);
        when(temperatureSensor.readTemperatureValue()).thenReturn(38.5); // Assuming 38.5 represents an abnormally high temperature
        BodyTemperatureMonitor monitor = new BodyTemperatureMonitor(temperatureSensor, null, null);
        
        double temperature = monitor.readTemperature();
        
        Assert.assertTrue("Temperature is not abnormally high", temperature > 37.5);
    }

	
}
