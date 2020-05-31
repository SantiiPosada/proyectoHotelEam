/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bo;

import Dao.DAOcompraHabitacion;
import Definiciones.IDAOCompraHabitacion;

/**
 *
 * @author santiago
 */
public class BOCompraHabitacion {
      private final IDAOCompraHabitacion daoCompraHabitacion;
      
      
      public BOCompraHabitacion(){
          daoCompraHabitacion=new DAOcompraHabitacion();
      }
      
}
