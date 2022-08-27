
package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<ClsVendedores> misEmp = new ArrayList();
        double tVenta=0;
        double comision=0;
        double tvc=0;
        double isr=0;
        double total=0;
        String nombres[]={"Leonel","Alejandro","Donald","Lester","Renato","Mateo","Raynor","Antonio"};
        
        for(int i=0; i<8; i++){
            misEmp.add(new ClsVendedores(nombres[i]));
            misEmp.get(i).setEnero(generarCantidad());
            misEmp.get(i).setFebrero(generarCantidad());
            misEmp.get(i).setMarzo(generarCantidad());
        }

        int i=1;
        System.out.printf("%-20s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s", "Nombre", "ENERO", "FEBRERO", "MARZO","T. VENTAS","20% // 35%","T.V.C","-ISR 5%","Tot. Liq.");
        System.out.println();
        for (ClsVendedores v : misEmp) {
            tVenta=v.getEnero()+v.getFebrero()+v.getMarzo();
            if(tVenta<=2000) comision= Math.round(tVenta*0.20 * 10.0) / 10.0;
            else comision=Math.round(tVenta*0.35 * 10.0) / 10.0;
            tvc=tVenta-comision;
            isr=Math.round(tvc*0.05 * 100.0) / 100.0;
            total=Math.round((tvc-isr) * 100.0) / 100.0;  ;
            
            System.out.format("%-21s",i+". "+ v.getNombre());
            System.out.format("%-16s", v.getEnero());
            System.out.format("%-16s", v.getFebrero());
            System.out.format("%-16s", v.getMarzo());
            System.out.format("%-16s", tVenta);
            System.out.format("%-16s", comision);
            System.out.format("%-16s", tvc);
            System.out.format("%-16s", isr);
            System.out.format("%-16s", total);
            System.out.println();
            i++;
        }
        
        double sumaEnero = 0, sumaFebrero=0, sumaMarzo=0;
        for (ClsVendedores v : misEmp){
            sumaEnero += v.getEnero();
            sumaFebrero+=v.getFebrero();
            sumaMarzo+=v.getMarzo();
        }

        System.out.println("\nLa suma de enero es="+sumaEnero);
        System.out.println("La suma de enero es="+sumaFebrero);
        System.out.println("La suma de enero es="+sumaMarzo);
    }
    
    public static int generarCantidad(){
        Random random = new Random();
        return random.nextInt(3001-500) + 500;//entre 500 y 3000
    }
}
