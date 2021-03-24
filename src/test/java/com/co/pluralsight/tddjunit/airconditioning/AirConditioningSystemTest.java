package com.co.pluralsight.tddjunit.airconditioning;

import com.co.pluralsight.tddjunit.MockitoExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@ExtendWith(MockitoExtension.class)
public class AirConditioningSystemTest {

    @InjectMocks
    AirConditioningSystem airConditioningSystem;

    @Mock
    Thermometer thermometer;

    @Test
    void testAirConditionedSystemStarted(){
        when(thermometer.getTemperature()).thenReturn(25.0);
        airConditioningSystem.setTemperatureThreshold(24.0);
        airConditioningSystem.checkAirConditioningSystem();
        Assertions.assertTrue(airConditioningSystem.isOpen());
        verify(thermometer,times(1)).getTemperature();
    }

    @Test
    void testAirConditionedSystemStopped(){
        when(thermometer.getTemperature()).thenReturn(23.0);
        airConditioningSystem.setTemperatureThreshold(24.0);
        airConditioningSystem.checkAirConditioningSystem();
        Assertions.assertFalse(airConditioningSystem.isOpen());
        verify(thermometer,times(1)).getTemperature();
    }
}
