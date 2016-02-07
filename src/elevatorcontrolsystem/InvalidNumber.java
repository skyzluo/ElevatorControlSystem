/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elevatorcontrolsystem;

/**
 *
 * @author think2
 */
public class InvalidNumber extends Exception {

    /**
     * Creates a new instance of <code>InvalidNumber</code> without detail
     * message.
     */
  

    /**
     * Constructs an instance of <code>InvalidNumber</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public InvalidNumber(String msg) {
        super(msg);
    }
}
