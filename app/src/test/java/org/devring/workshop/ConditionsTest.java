package org.devring.workshop;

import org.devring.workshop.Conditions.OsName;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledIf;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

public class ConditionsTest {

    @Test
    @EnabledOnOs(value = OS.LINUX)
    void shouldReturnLinuxOnLinux() {
        //given
        var expected = OsName.LINUX;
        //when
        var actual = new Conditions().getOsName();
        //then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @EnabledOnOs(value = OS.WINDOWS)
    void shouldReturnWindowsOnWindows() {
        //given
        var expected = OsName.WINDOWS; 
        //when
        var actual = new Conditions().getOsName();
        //then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @EnabledOnOs(value = OS.MAC)
    @Tag("fast")
    @DisplayName("Fast test running only on Macs")
    void shouldReturnMacOnMac() {
        //given
        var expected = OsName.MAC; 
        //when
        var actual = new Conditions().getOsName();
        //then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisabledOnOs(value = OS.MAC)
    void shouldNotReturnMacOnNotMac() {
        //given
        var notAllowed = OsName.MAC; 
        //when
        var actual = new Conditions().getOsName();
        //then
        Assertions.assertNotEquals(notAllowed, actual);
    }

    @Test
    @DisabledOnOs(value = OS.MAC)
    @Tag("fast")
    void fastTest() {
        Assertions.assertTrue(true);
    }

    @Test
    @EnabledIfSystemProperty(named = "os.name", matches = "Linux")
    void shouldReturnLinuxOnLinuxBySystemProperty() {
        //given
        var expected = OsName.LINUX;
        //when
        var actual = new Conditions().getOsName();
        //then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @EnabledIfSystemProperty(named = "machine", matches = "dbServer")
    void shouldBeRunWhenPropertySet() {
        Assertions.assertTrue(true);
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "ENV", matches = "prod")
    void shouldNotBeRunOonEnvProperty() {
        Assertions.assertTrue(true);
    }

    public static boolean myConditionChecker() {
        return false;
    }

    @Test
    @EnabledIf(value = "myConditionChecker")
    void shouldBeRunOnExternalCondition() {
        Assertions.assertTrue(true);
    }


    @Test
    @Disabled
    void shouldCheckFoo() {
        //given
        var testString = "BazBar";
        //when
        var actual = new Conditions().checkIfFoo(testString);

        Assertions.assertFalse(actual);;
    }

    @Test
    void shuldRunAssumingSystemIsMac() {
        Assumptions.assumeTrue(
            System.getProperty("os.name").startsWith("Mac"), 
            "I run on mac only!");

        Assertions.assertTrue(true);
    }

}
