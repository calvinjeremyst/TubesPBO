/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author lenovo
 */
public class UserManager {
    
    private static UserManager instance;
    private Member mem;
    
    public static UserManager getInstance(){
    
        if(instance == null){
            instance = new UserManager();
        
        }
        return instance;
    }

    public Member getMem() {
        return mem;
    }

    public void setMem(Member mem) {
        this.mem = mem;
    }
    
    
}
