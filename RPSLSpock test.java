package edu.cscc;

import org.junit.Assert;
import org.junit.Test;

/**
 * Set of unit tests for RPSLSpock methods
 */
public class RPSLSpockTest {

    /**
     * Test isValidPick() method
     * Test that it returns true if argument is {rock,paper,scissors,lizard, or spock}
     * Test that it returns false if the argument is not a valid input String
     */
    @Test
    public void isValidPick() {
        Assert.assertTrue(RPSLSpock.isValidPick(RPSLSpock.LIZARD));
        Assert.assertTrue(RPSLSpock.isValidPick(RPSLSpock.SPOCK));
        Assert.assertTrue(RPSLSpock.isValidPick(RPSLSpock.ROCK));
        Assert.assertTrue(RPSLSpock.isValidPick(RPSLSpock.PAPER));
        Assert.assertTrue(RPSLSpock.isValidPick(RPSLSpock.SCISSORS));

        Assert.assertFalse(RPSLSpock.isValidPick(null));
    }

    /**
     * Test generatePick() method
     * Test that it returns a non-null String
     * Test that the String it returns is valid
     * Since the method is based on a RANDOM number - test it ONE MILLION times
     */
    @Test
    public void generatePick() {
        for (int i=0; i<1000000; ++i) {
            String pick = RPSLSpock.generatePick();
            Assert.assertNotNull(pick);
            Assert.assertTrue(RPSLSpock.isValidPick(pick));
        }
    }

    /**
     * Test the isComputerWin method
     * Test it with all ten possible computer win scenarios (it should return true)
     * Test it with at least one computer loses scenario to make sure it returns false
     */
    @Test
    public void isComputerWin() {
        Assert.assertTrue(RPSLSpock.isComputerWin(RPSLSpock.ROCK,RPSLSpock.SCISSORS));
        Assert.assertTrue(RPSLSpock.isComputerWin(RPSLSpock.ROCK,RPSLSpock.LIZARD));
        Assert.assertTrue(RPSLSpock.isComputerWin(RPSLSpock.PAPER,RPSLSpock.ROCK));
        Assert.assertTrue(RPSLSpock.isComputerWin(RPSLSpock.PAPER,RPSLSpock.SPOCK));
        Assert.assertTrue(RPSLSpock.isComputerWin(RPSLSpock.SCISSORS,RPSLSpock.PAPER));
        Assert.assertTrue(RPSLSpock.isComputerWin(RPSLSpock.SCISSORS,RPSLSpock.LIZARD));
        Assert.assertTrue(RPSLSpock.isComputerWin(RPSLSpock.LIZARD,RPSLSpock.PAPER));
        Assert.assertTrue(RPSLSpock.isComputerWin(RPSLSpock.LIZARD,RPSLSpock.SPOCK));
        Assert.assertTrue(RPSLSpock.isComputerWin(RPSLSpock.SPOCK,RPSLSpock.ROCK));
        Assert.assertTrue(RPSLSpock.isComputerWin(RPSLSpock.SPOCK,RPSLSpock.SCISSORS));

        Assert.assertFalse(RPSLSpock.isComputerWin(RPSLSpock.SCISSORS,RPSLSpock.SPOCK));
    }
}
