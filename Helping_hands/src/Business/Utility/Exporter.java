/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Utility;
import javax.swing.*;
import java.io.*;
import javax.swing.table.TableModel;

/**
 *
 * @author arpit
 */
public class Exporter {
      public Exporter() { }
      

    public void exportTable(JTable table, File file) throws IOException { 
        TableModel model = table.getModel();
        FileWriter out = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(out);
        for(int i=0;i<model.getColumnCount();i++)
        {
            bw.write(model.getColumnName(i)+",");
        }
//        System.out.println("rows"+model.getRowCount()+"column"+model.getColumnCount()+"Value"+model.getValueAt(2,4).toString());
        bw.write("\n");
        for(int i=0;i<model.getRowCount();i++)
        { 
             for(int j=0;j<model.getColumnCount();j++)
        {   
          bw.write(model.getValueAt(i,j).toString()+",");  
        }
        bw.write("\n");
        }
        bw.close(); 
    } 
}
