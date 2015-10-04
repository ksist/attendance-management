/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ncsa.tec.kasai.attendance.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ncsa.tec.kasai.attendance.entity.User;

/**
 *
 * @author kasai
 */
@Stateless
public class UserFacade extends AbstractFacade<User> {
    @PersistenceContext(unitName = "ncsa.tec.kasai_Attendance_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(User.class);
    }
    
    public boolean isAuth(String username, String password) {
        User user = em.find(User.class, username);
        return password.equals(user.getPassword());
    }
    
}
