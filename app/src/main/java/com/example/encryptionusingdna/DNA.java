package com.example.encryptionusingdna;

import android.widget.Toast;

import java.util.ArrayList;

public class DNA {
    public static String[] split_binary(String binary){
        ////////////split binary to character and insert all 2 char in index in array
        int counter=0;
        String[] arr_binary =new String[binary.length()/2];
        for(int i=0; i< binary.length(); i+=2){
            arr_binary[counter]=binary.substring(i,i+2);
            counter++;
        }
        //////////////////////end split binary
        return arr_binary;
    }
    public static String convert_to_dna(String[] binary){

        /////////////////////start convert to DNA
        String[] dna_arr=new String[binary.length];
        for(int i=0; i<binary.length ; i++){
            if(binary[i].equals("00")){
                dna_arr[i]="A";
            }
            else if(binary[i].equals("01")){
                dna_arr[i]="C";
            }
            else if(binary[i].equals("10")){
                dna_arr[i]="G";
            }
            else if(binary[i].equals("11")){
                dna_arr[i]="T";
            }
        }
        //////////////////////end convert to DNA
        String End_Result="";
        for(int i=0; i<dna_arr.length;i++){
            End_Result+=dna_arr[i]+"AAAAA";
        }
        return End_Result;
    }
    /////////////////////////////////////////////////////////////////
    public static String split_dna(String finaldna){
        /////Remove AAAAA From DNA
        String ResultDNA="";
        String[] arr_final_dna=new String[finaldna.length()];
        int i=0;
        for(char c:finaldna.toCharArray()){
            arr_final_dna[i]=String.valueOf(c);
            i++;
        }
        for(int j=0; j<arr_final_dna.length; j+=6){
            ResultDNA+=arr_final_dna[j];
        }
        return ResultDNA;
    }
    ///////////start convert from DNA to binary
    public static String convert_from_DNA_to_binary(String dna_sequence){
        String[] DNA_sequence=new String[dna_sequence.length()];
        int i=0;
        for(char c:dna_sequence.toCharArray()){
            DNA_sequence[i]=String.valueOf(c);
            i++;
        }
        String Result_Binary="";
       for(int x=0; x<DNA_sequence.length; x++){
          if(DNA_sequence[x].equals("A")){
              Result_Binary+="00";
          }
          else if(DNA_sequence[x].equals("C")){
              Result_Binary+="01";
          }
          else if(DNA_sequence[x].equals("G")){
              Result_Binary+="10";
          }
          else if(DNA_sequence[x].equals("T")){
              Result_Binary+="11";
          }
       }
       return Result_Binary;
    }
}
