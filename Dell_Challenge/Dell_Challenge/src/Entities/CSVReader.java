package Entities;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CSVReader{
    private String csvFile = "C:\\gerint_solicitacoes_mod.csv";
    private String line = "";
    private List<String> csvData = new ArrayList<String>();

    public CSVReader(){

    }
    public List<String> readCSV(){
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(csvFile));
            while((line = br.readLine()) != null){
                String[] data = line.split(",");
                //System.out.println(data[0]);
                for(int i = 0; i<data.length; i++){
                    csvData.add(data[i]);
                }
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return csvData;
    }
    
}