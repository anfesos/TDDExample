package com.co.pluralsight.tddjunit.airport;

import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AiportTest {

    @DisplayName("Given there is an economy flight")
    @Nested
    class economyFlightTest {
        private Flight economyFlight;
        private Passenger mike;
        private Passenger john;

        @BeforeEach
        void setUp() {
            economyFlight = new EconomyFlight("1");
            mike = new Passenger("Mike", false);
            john = new Passenger("John", true);
        }

        @Nested
        @DisplayName("When we have a usual passenger")
        class UsualPassenger {

            @Test
            @DisplayName("Then you can add and remove him from an economy flight")
            public void testEconomyFlightUsualPassenger() {
                assertAll("Verify all conditions for a usual passenger and an economy flight",
                        () -> assertEquals("1", economyFlight.getId()),
                        () -> assertEquals(true, economyFlight.addPassenger(mike)),
                        () -> assertEquals(1, economyFlight.getPassengersSet().size()),
                        () -> assertTrue(economyFlight.getPassengersSet().contains(mike)),
                        () -> assertEquals(true, economyFlight.removePassenger(mike)),
                        () -> assertEquals(0, economyFlight.getPassengersSet().size())
                );

            }
        }

        @Nested
        @DisplayName("When we have a VIP passenger")
        class VipPassenger {
            @Test
            @DisplayName("Then you can add him but cannot remove him from an economy flight")
            public void testEconomyFlightPassenger() {
                assertAll("Verify all conditions for a VIP passenger and an economy flight",
                        () -> assertEquals("1", economyFlight.getId()),
                        () -> assertEquals(true, economyFlight.addPassenger(john)),
                        () -> assertEquals(1, economyFlight.getPassengersSet().size()),
                        () -> assertTrue(economyFlight.getPassengersSet().contains(john)),
                        () -> assertEquals(false, economyFlight.removePassenger(john)),
                        () -> assertEquals(1, economyFlight.getPassengersSet().size())
                );
            }


            @DisplayName("Then you cannot add him to an economy flight more than once")
            //@Disabled -> Anotación para deshabilitar momentaneamente la ejecución del test
            @RepeatedTest(5)
            public void testEconomyFlightUsualPassengerAddedOnlyOnce(RepetitionInfo repetitionInfo){
                for(int i= 0; i<repetitionInfo.getCurrentRepetition(); i++){
                    economyFlight.addPassenger(mike);
                }
                assertAll(
                        "Verify a usual passenger can be added to an economy flight only once",
                        () -> assertEquals(1,economyFlight.getPassengersSet().size()),
                        () -> assertTrue(economyFlight.getPassengersSet().contains(mike)),
                        () -> assertTrue(new ArrayList<>(economyFlight.getPassengersSet()).get(0).getName().equals("Mike"))
                );
            }
        }


    }


    @DisplayName("Given there is a business flight")
    @Nested
    class BusinessFlightTest {
        private Flight businessFlight;
        private Passenger mike;
        private Passenger john;

        @BeforeEach
        void setUp() {
            businessFlight = new BusinessFlight("2");
            mike = new Passenger("Mike", false);
            john = new Passenger("John", true);
        }

        @Nested
        @DisplayName("When we have a usual Passenger")
        class UsualPassenger {

            @Test
            @DisplayName("Then you cannot add or remove him from a business flight")
            public void testBusinessFlightUsualPassenger() {
                assertAll(
                        "Verify all conditions for a usual passenger and an business flight",
                        () -> assertEquals(false, businessFlight.addPassenger(mike)),
                        () -> assertEquals(0, businessFlight.getPassengersSet().size()),
                        () -> assertEquals(false, businessFlight.removePassenger(mike)),
                        () -> assertEquals(0, businessFlight.getPassengersSet().size())
                );

            }

        }

        @Nested
        @DisplayName("When we have a VIP Passenger")
        class VipPassenger {
            @Test
            @DisplayName("Then you can add him but cannot remove him from a business flight")
            public void testBusinessFlightPassenger() {
                assertAll(
                        "Verify all conditions for a VIP passenger and an business flight",
                        () -> assertEquals(true, businessFlight.addPassenger(john)),
                        () -> assertEquals(1, businessFlight.getPassengersSet().size()),
                        () -> assertEquals(false, businessFlight.removePassenger(john)),
                        () -> assertEquals(1, businessFlight.getPassengersSet().size())
                );
            }

            @DisplayName("Then you cannot add him to an Business flight more than once")
            @RepeatedTest(5)
            public void testEconomyFlightUsualPassengerAddedOnlyOnce(RepetitionInfo repetitionInfo){
                for(int i= 0; i<repetitionInfo.getCurrentRepetition(); i++){
                    businessFlight.addPassenger(john);
                }
                assertAll(
                        "Verify a VIP passenger can be added to an Business flight only once",
                        () -> assertEquals(1,businessFlight.getPassengersSet().size()),
                        () -> assertTrue(businessFlight.getPassengersSet().contains(john)),
                        () -> assertTrue(new ArrayList<>(businessFlight.getPassengersSet()).get(0).getName().equals("John"))
                );
            }
        }
    }

    @Nested
    @DisplayName("Given there is a Premium flight")
    class PremiumFlightTest{

        private Flight premiumFlight;
        private Passenger mike;
        private Passenger john;

        @BeforeEach
        public void setUp(){
            premiumFlight = new PremiumFlight("3");
            mike = new Passenger("Mike",false);
            john = new Passenger("John", true);
        }

        @Nested
        @DisplayName("When we have a usual Passenger")
        class UsualPassenger{

            @Test
            @DisplayName("Then you cannot add or remove him from a premium flight")
            public void testPremiumFlightUsualPassenger(){
                assertAll("Verify all conditions for a usual passenger and a premium flight",
                        ()-> assertEquals(false, premiumFlight.addPassenger(mike)),
                        ()-> assertEquals(0, premiumFlight.getPassengersSet().size()),
                        ()-> assertEquals(false, premiumFlight.removePassenger(mike)),
                        ()-> assertEquals(0, premiumFlight.getPassengersSet().size())
                        );

            }

        }

        @Nested
        @DisplayName("When we have a Vip Passenger")
        class VipPassenger{
            @Test
            @DisplayName("Then you can add and remove him from a premium flight")
            public void testPremiumFlightPassenger(){
                assertAll(
                        "Verify all conditions for a VIP¨passenger and a premium flight",
                        () -> assertEquals(true , premiumFlight.addPassenger(john)),
                        () -> assertEquals(1 , premiumFlight.getPassengersSet().size()),
                        () -> assertEquals(true , premiumFlight.removePassenger(john)),
                        () -> assertEquals(0 , premiumFlight.getPassengersSet().size())
                );
            }

            @DisplayName("Then you cannot add him to an Premium flight more than once")
            @RepeatedTest(5)
            public void testEconomyFlightUsualPassengerAddedOnlyOnce(RepetitionInfo repetitionInfo){
                for(int i= 0; i<repetitionInfo.getCurrentRepetition(); i++){
                    premiumFlight.addPassenger(john);
                }
                assertAll(
                        "Verify a VIP passenger can be added to an premium flight only once",
                        () -> assertEquals(1,premiumFlight.getPassengersSet().size()),
                        () -> assertTrue(premiumFlight.getPassengersSet().contains(john)),
                        () -> assertTrue(new ArrayList<>(premiumFlight.getPassengersSet()).get(0).getName().equals("John"))
                );
            }
        }

    }
}
