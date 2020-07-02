import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class AED2Ep1 {
    public static List<Local> locais = new ArrayList<>();
    
    public static void main(String[] args) {

        long startTime = System.nanoTime();
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o caminho do arquivo a ser lido");

        //Lendo o arquivo .csv contendo as informações das viagens
        try (BufferedReader br = new BufferedReader (new FileReader(sc.nextLine()))){

            String aux = br.readLine(); // linha de legendas
            String linha = br.readLine();
            while(linha != null){

                String[] viagem = linha.split(",");  

                Local domicilio = null;
                if (!viagem[2].equals("0") && !viagem[3].equals("0")) {

                    domicilio = criaLocal(viagem, 2, 3);
                    inserirCoordenadas(domicilio, Long.parseLong(viagem[43]));
                }
                Local escola = null;
                if (!viagem[57].equals("0") && !viagem[58].equals("0")) { 

                    escola = criaLocal(viagem, 57, 58);                
                    inserirCoordenadas(escola, Long.parseLong(viagem[43]));
                }
                Local primeiroTrab = null;
                if (!viagem[62].equals("0") && !viagem[63].equals("0")) { 

                    primeiroTrab = criaLocal(viagem, 62, 63);                
                    inserirCoordenadas(primeiroTrab, Long.parseLong(viagem[43]));
                }
                Local segundoTrab = null;
                if (!viagem[71].equals("0") && !viagem[72].equals("0")) {  

                    segundoTrab = criaLocal(viagem, 71, 72);                
                    inserirCoordenadas(segundoTrab, Long.parseLong(viagem[43]));
                }
                Local origem = null;
                if (!viagem[84].equals("0") && !viagem[85].equals("0")) {

                    origem = criaLocal(viagem, 84, 85);                
                    inserirCoordenadas(origem, Long.parseLong(viagem[43]));
                }
                Local destino = null;
                if (!viagem[88].equals("0") && !viagem[89].equals("0")) {  

                    destino = criaLocal(viagem, 88, 89);                
                    inserirCoordenadas(destino, Long.parseLong(viagem[43]));
                }
                Local primeiraTransf = null;
                if (!viagem[92].equals("0") && !viagem[93].equals("0")) {     

                    primeiraTransf = criaLocal(viagem, 92, 93);                
                    inserirCoordenadas(primeiraTransf, Long.parseLong(viagem[43]));
                }
                Local segundaTransf = null;
                if (!viagem[96].equals("0") && !viagem[97].equals("0")) {   

                    segundaTransf = criaLocal(viagem, 96, 97);                
                    inserirCoordenadas(segundaTransf, Long.parseLong(viagem[43]));
                }
                Local terceiraTransf = null;
                if (!viagem[100].equals("0") && !viagem[101].equals("0")) {   

                    terceiraTransf = criaLocal(viagem, 100, 101);                
                    inserirCoordenadas(terceiraTransf, Long.parseLong(viagem[43]));
                }               
                
                linha = br.readLine();
            }

            System.out.print("Digite o caminho do arquivo de saída");
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(sc.nextLine()))){

                bw.write("Coordenada_x,Coordenada_y,Frequentadores");
                bw.newLine();
                for (Local l : locais){

                    bw.write(l.getCoordenada_x() + "," + l.getCoordenada_y() + "," + l.tamanhoPilha());
                    bw.newLine();
                }
            }
            catch (IOException e){

                e.getMessage();
                e.printStackTrace();
            }        
        }catch (IOException e){

            e.getMessage();
            e.printStackTrace();
        }

        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("Tempo que demorou para processar tudo:" + totalTime);
    }

    public static Local criaLocal(String[] viagem, int x, int y){

        int coordenada_x = Integer.parseInt(viagem[x]);
        int coordenada_y = Integer.parseInt(viagem[y]);
        return new Local(coordenada_x, coordenada_y);
    }

    public static void inserirCoordenadas(Local L, long ID){

        if(locais.contains(L)){
            for(Local local : locais){
                if(L.equals(local) && local.buscar(ID) == null){

                    local.inserirNode(ID);
                    break;
                }
            }        
        }else{

            locais.add(L);
            L.inserirNode(ID);
        }       
    }
}
