/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.una.estructura.view;

/**
 *
 * @author Eddier Lopez
 */

/**UI--> User Interface (Interfaz de Usuario)*
 *  CLI---> Command Line Interface
 *  GUI---> Graphic User Interface
 *  NUI---> Natural User Interface
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Console;
import java.io.IOException;
public class UI {
    private static Console console=System.console();
    private static BufferedReader reader=
            new BufferedReader(new InputStreamReader(System.in));
    
    public static String[] inputs(String title,String[] msgs){
        String[] response=new String[msgs.length];
        println("======"+title+"=======");
        for(int i=0;i<msgs.length;i++){
            response[i]=input(msgs[i]);     
        }
        return response;
    }
    public static String input(String msg){
        boolean flag=false;
        String response;
        do{
            print(msg+":");
            response=readLine();
            if(response.equals("")){
                println("No se permiten entradas vacias");
                flag=true;
            }else{
                flag=false;
            }
        }while(flag);
        return response;
    }
    private static String readLine(){
        if(console!=null){
            return console.readLine();
        }else{
            try{
                return reader.readLine();
            }catch(IOException ex){
                print("Error de lectura del sistema");
                return "";
            }
        }
    }
    public static void print(String msg){
        System.out.print(msg);
    }
    public static void println(String msg){
        System.out.println(msg);
    }
    public static int menu(String title,String[] options){
        int opt=-1;
        println("++++++++"+title.toUpperCase()+"++++++++");
        println("Seleccione una opción.");
        for(int i=0;i<options.length;i++){
            println((i+1)+"---------"+options[i]);
        }
        do{
            //SE DEBE VALIDAR QUE LA ENTRADA SEA NUMERICA
            opt=Integer.parseInt(readLine().trim());
        }while(opt==-1);
        return opt-1;
    }
    
}
