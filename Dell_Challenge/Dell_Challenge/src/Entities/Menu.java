package Entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    CSVReader csvReader = new CSVReader();
    List<String> allData = new ArrayList<String>();
    
    public Menu(){
    }
    
    public void menuExe(int op){
        int count = 0;
        int mCount = 0;
        int fCount = 0;
        Double ageSumMale = 0.0;
        Double ageSumFemale = 0.0;
        String municipio_residencia;
        String executante;
        String solicitante;
        String row;
        String[] splitRow;
        allData = csvReader.readCSV();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        int count2018 = 0;
        int count2019 = 0;
        int count2020 = 0;
        int count2021 = 0;
        Integer waitTime;
        List<Integer> wait = new ArrayList<Integer>();

        switch(op){
        case 1:
        System.out.println("Informe o nome do município residencial:");
        municipio_residencia = sc.nextLine();
        municipio_residencia = municipio_residencia.toUpperCase();
        for(int i = 1; i<allData.size(); i++){
            row = allData.get(i);
            splitRow = row.split(";");
            if(splitRow[7].equals(municipio_residencia)){
                count++;
            if(splitRow[5].equals("MASCULINO")){
                mCount++;
                try{
                    ageSumMale += Double.parseDouble(splitRow[6]);
                }catch(NumberFormatException e){
                    
                }
                }
            if(splitRow[5].equals("FEMININO")){
                fCount++;
                try{
                    ageSumFemale += Double.parseDouble(splitRow[6]);
                }catch(NumberFormatException e){
                    
                }
                
            }
            }
            
            
        }
            System.out.println("Numero total de pacientes do município: "+ count);
            System.out.println("Média de idade dos pacientes do sexo masculino: "+ageSumMale/mCount);
            System.out.println("Média de idade dos pacientes do sexo feminino: "+ageSumFemale/fCount);
            System.out.println("Média de idade de todos os pacientes: "+(ageSumMale+ageSumFemale)/count);
            break;
        case 2:
        System.out.println("Informe o nome do município residencial:");
        municipio_residencia = sc.nextLine();
        municipio_residencia = municipio_residencia.toUpperCase();
        for(int i = 1; i<allData.size(); i++){
            row = allData.get(i);
            splitRow = row.split(";");
            if(splitRow[7].equals(municipio_residencia)){
                try{
                    cal.setTime(formatter.parse(splitRow[15]));
                }catch(ParseException e){
                    }
                    int year = cal.get(Calendar.YEAR);
                    if(year == 2018){
                        count2018++;
                    }else if(year == 2019){
                        count2019++;
                    }else if(year == 2020){
                        count2020++;
                    }else if(year == 2021){
                        count2021++;
                    }
            }
            }
        System.out.println("No ano de 2018 foram internados "+count2018+" pacientes");
        System.out.println("No ano de 2019 foram internados "+count2019+" pacientes");
        System.out.println("No ano de 2020 foram internados "+count2020+" pacientes");
        System.out.println("No ano de 2021 foram internados "+count2021+" pacientes");
        break;

        case 3:
            System.out.println("Digite o nome do executante: ");
            executante = sc.nextLine();
            executante = executante.toUpperCase();
            for(int i = 1; i<allData.size(); i++){
                row = allData.get(i);
                splitRow = row.split(";");
                if(splitRow[17].equals(executante)){
                    try{
                    System.out.println("Idade: "+splitRow[6]+" /Município residencial: "+splitRow[7]+
                    " /Solicitante: "+splitRow[8]+" /Data de autorização: "+formatter2.parse(splitRow[14])+
                    " /Data de internação: "+formatter2.parse(splitRow[15])+" /Data de alta: "+formatter2.parse(splitRow[16])+
                    " /Executante: "+splitRow[17]);
                    System.out.println("--------------------------------------------------------------------");
                    }catch(ParseException e){

                    }
                    
                }
            }
            break;
            case 4:
            System.out.println("Digite o nome do solicitante: ");
            solicitante = sc.nextLine();
            solicitante = solicitante.toUpperCase();
            for(int i = 1; i<allData.size(); i++){
                row = allData.get(i);
                splitRow = row.split(";");
                if(splitRow[8].equals(solicitante)){
                    try{
                    cal.setTime(formatter2.parse(splitRow[16]));
                    cal2.setTime(formatter2.parse(splitRow[4]));
                    }catch(ParseException e){

                    }
                    long diff = cal.getTimeInMillis() - cal2.getTimeInMillis();
                    
                    System.out.println("ID Usuário: "+splitRow[1]+" /Hospital executante: "+splitRow[17]+
                    " /Número de dias desde a solicitação até a alta: "+diff/(1000*60*60*24)+" dias");
                }
            }
            break;
            case 5:
            for(int i = 1; i<allData.size(); i++){
                row = allData.get(i);
                splitRow = row.split(";");
                waitTime = Integer.parseInt(splitRow[18]);
                wait.add(waitTime);
            }
            Collections.sort(wait, Collections.reverseOrder());
            for(int k = 0; k<5; k++){
                System.out.println(k+1+". "+wait.get(k)+" horas na fila");

            }
            break;
        }

    }
    
}


