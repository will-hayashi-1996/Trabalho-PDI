package Interface;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 *
 * @author akume
 */
public class PDI_Atividade_1 {

    public int[][] matriz;

    public int[][] matriz2;
    
    public int[][] matriz3;
    
    public int[][] matrizR;
    
    public int[][] matrizG;
    
    public int[][] matrizB;
    
    public String Magic_number;

    public int[][] soma;

    public File arquivo;

    public int linha;

    public int coluna;

    public int linha2;
    
    public int coluna2;
    
    public int linha3;
    
    public int coluna3;
    
    public boolean flag = false;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int[][] getMatriz3() {
        return matriz3;
    }

    public void setMatriz3(int[][] matriz3) {
        this.matriz3 = matriz3;
    }

    public int getLinha3() {
        return linha3;
    }

    public void setLinha3(int linha3) {
        this.linha3 = linha3;
    }

    public int getColuna3() {
        return coluna3;
    }

    public void setColuna3(int coluna3) {
        this.coluna3 = coluna3;
    }
    
    public String getMagic_number() {
        return Magic_number;
    }

    public void setMagic_number(String Magic_number) {
        this.Magic_number = Magic_number;
    }
    
    public int getLinha2() {
        return linha2;
    }

    public void setLinha2(int linha2) {
        this.linha2 = linha2;
    }

    public int getColuna2() {
        return coluna2;
    }

    public void setColuna2(int coluna2) {
        this.coluna2 = coluna2;
    }


    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public int getColuna() {
        return coluna;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }

    public void ler_arquivo() throws FileNotFoundException, IOException {
        JFileChooser fc = new JFileChooser("C:\\Users\\akume\\Desktop\\PDI_Atividade_1_Interface\\imagem");
        String filename = null;
        int result;
        result = fc.showOpenDialog(null);
        if (result == javax.swing.JFileChooser.APPROVE_OPTION) {
            filename = fc.getSelectedFile().getAbsolutePath();
            //this.setArquivo(filename);
            
            Scanner scanner = null;
            try {
                File temp_arq;
                scanner = new Scanner(temp_arq=new File(filename));
                this.setArquivo(temp_arq);
                scanner.useLocale(Locale.ROOT);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(PDI_Atividade_1.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            String aux=null;
            aux=scanner.next(); // magic number
            String aux2=null;
      
          
            if(aux.equals("P3")){
                    
                    this.setMagic_number(aux);
                    int width=0;
                    aux2=scanner.next();
                    if(aux2.charAt(0) == '#'){
                          scanner.nextLine();
                          this.setFlag(true);
                          width =  scanner.nextInt();
                    }else{
                         width = Integer.parseInt(aux2);
                    } 
                    int height = scanner.nextInt();
                    int max = scanner.nextInt();
                    
                    
                
                    this.matrizR= new int[height][width];
                    this.setMatrizR(matrizR);
                    this.matrizG= new int[height][width];
                    this.setMatrizG(matrizG);
                    this.matrizB= new int[height][width];
                    this.setMatrizB(matrizB);
                    
                    this.setLinha(height);
                    this.setColuna(width);
        
                    for(int i=0;i<this.getLinha();i++){
                        for(int j=0;j<this.getColuna();j++){
                             
                            // normalize to 255
                            int value  = scanner.nextInt();
                            int value2 = scanner.nextInt();
                            int value3 = scanner.nextInt();
                            value  = (int) Math.round(((double) value) / max * 255);
                            value2 = (int) Math.round(((double) value2) / max * 255);
                            value3 = (int) Math.round(((double) value3) / max * 255);
                            this.matrizR[i][j] = value;
                            this.matrizG[i][j] = value2;
                            this.matrizB[i][j] = value3;        
                            //System.out.println(matriz[i][j]);
                        }
                    }
                
            }
            else{
                
                   this.setMagic_number(aux);
                   int width=0;
                   aux2=scanner.next();
                    if(aux2.charAt(0) == '#'){
                       scanner.nextLine();
                       this.setFlag(true);
                       width =  scanner.nextInt();
                                
                    }
                   
                    else{
                     width =  Integer.parseInt(aux2);
                    }
                    
                    int height = scanner.nextInt();
                    int max = scanner.nextInt();
                    
                this.matriz = new int[height][width];
                this.setMatriz(matriz);
                this.setLinha(height);
                this.setColuna(width);

            for (int i = 0; i < this.getLinha(); ++i) {
                for (int j = 0; j < this.getColuna(); ++j) {
                    // normalize to 255
                    int value = scanner.nextInt();
                    value = (int) Math.round(((double) value) / max * 255);
                    this.matriz[i][j] = value;
                    //System.out.println(matriz[i][j]);

                        }
                    }

                

            
            }
      
        }
    }

    public int[][] getMatrizR() {
        return matrizR;
    }

    public void setMatrizR(int[][] matrizR) {
        this.matrizR = matrizR;
    }

    public int[][] getMatrizG() {
        return matrizG;
    }

    public void setMatrizG(int[][] matrizG) {
        this.matrizG = matrizG;
    }

    public int[][] getMatrizB() {
        return matrizB;
    }

    public void setMatrizB(int[][] matrizB) {
        this.matrizB = matrizB;
    }

    public File getArquivo() {
        return arquivo;
    }

    public void setArquivo(File arquivo) {
        this.arquivo = arquivo;
    }

    public PDI_Atividade_1() throws FileNotFoundException, IOException {
        this.ler_arquivo();
        //this.exibir(matriz);
        //this.inverter(matriz);
        //this.escurecer(matriz);
        //this.escurecerDiv(matriz);
        //this.clarear(matriz);
        //this.clarearMult(matriz);
        //this.Girar90neg(matriz);
        //this.Girar180(matriz);
        //this.exibir(matriz);
        //this.alterar_arquivo(arq);

        //matriz=Somar_Matriz();
    }

    public int[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }

    public int[][] getMatriz2() {
        return matriz2;
    }

    public void setMatriz2(int[][] matriz2) {
        this.matriz2 = matriz2;
    }

    public int[][] getSoma() {
        return soma;
    }

    public void setSoma(int[][] soma) {
        this.soma = soma;
    }

    public void exibir(int[][] matriz) {

        for (int i = 0; i < this.getLinha(); i++) {
            for (int j = 0; j < this.getColuna(); j++) {

                System.out.println(matriz[i][j]);
            }
        }
    }
   
    public void exibir2(int[][] matriz) {

        for (int i = 0; i < this.getLinha(); i++) {
            for (int j = 0; j < this.getColuna(); j++) {

                System.out.println(matriz[i][j]);
            }
        }
    }
   
    public void exibirR(int[][] matriz) {

        for (int i = 0; i < this.getLinha(); i++) {
            for (int j = 0; j < this.getColuna(); j++) {

                System.out.println(matrizR[i][j]);
            }
        }
    }
    
    public void exibirB(int[][] matriz) {

        for (int i = 0; i < this.getLinha(); i++) {
            for (int j = 0; j < this.getColuna(); j++) {

                System.out.println(matrizB[i][j]);
            }
        }
    }
    
    public void exibirG(int[][] matriz) {

        for (int i = 0; i < this.getLinha2(); i++) {
            for (int j = 0; j < this.getColuna2(); j++) {

                System.out.println(matrizG[i][j]);
            }
        }
    }

    public int[][] inverter(int[][] image) throws FileNotFoundException {
        /*
    int width = image[0].length;
    int height = image.length;
         */
        //int[][] result = new int[height][width];

        for (int i = 0; i < this.getLinha(); ++i) {
            for (int j = 0; j < this.getColuna(); ++j) {
                this.matriz[i][j] = 255 - image[i][j];
            }
        }
        return this.matriz;
    }

    public int[][] escurecer(int[][] image, int valor) throws FileNotFoundException {
        /*
    int width = image[0].length;
    int height = image.length;
         */
        //int[][] result = new int[height][width];
        /*
      int aux=0;
      do{
        Scanner scan= new Scanner(System.in);
        System.out.println("Digite o valor a ser subtraído do arquivo");
        aux= scan.nextInt();
       }while(aux <1 || aux >255);
         */

        for (int i = 0; i < this.getLinha(); ++i) {
            for (int j = 0; j < this.getColuna(); ++j) {
                this.matriz[i][j] = this.matriz[i][j] - valor;
                if (this.matriz[i][j] < 0) {
                    this.matriz[i][j] = 0;
                }
            }
        }
        return this.matriz;
    }

    public int[][] clarear(int[][] image, int valor) throws FileNotFoundException {

        for (int i = 0; i < this.getLinha(); ++i) {
            for (int j = 0; j < this.getColuna(); ++j) {
                this.matriz[i][j] = this.matriz[i][j] + valor;
                if (this.matriz[i][j] > 255) {
                    this.matriz[i][j] = 255;
                }
            }
        }
        return this.matriz;
    }

    public int[][] escurecerDiv(int[][] image, double valor) throws FileNotFoundException {

        double aux = 0;

        for (int i = 0; i < this.getLinha(); ++i) {
            for (int j = 0; j < this.getColuna(); ++j) {
                aux = (double) matriz[i][j] / valor;
                matriz[i][j] = (int) Math.round(aux);
                if (this.matriz[i][j] < 0) {
                    this.matriz[i][j] = 0;
                }
            }
        }
        return this.matriz;
    }

    public int[][] clarearMult(int[][] image, double valor) throws FileNotFoundException {

        double aux = 0;

        for (int i = 0; i < this.getLinha(); ++i) {
            for (int j = 0; j < this.getColuna(); ++j) {
                aux = (double) matriz[i][j] * valor;
                matriz[i][j] = (int) Math.round(aux);
                if (this.matriz[i][j] > 255) {
                    this.matriz[i][j] = 255;
                }
            }
        }
        return this.matriz;
    }

    public int[][] Girar90(int[][] image) throws FileNotFoundException {
        /*
    int width = image[0].length;
    int height = image.length;
         */
        //int[][] result = new int[height][width];
        int x = 0;
        int y = 0;
        this.matriz2 = new int[this.getLinha()][this.getColuna()];
        for (int i = 0; i < this.getLinha(); i++) {
            for (int j = 0; j < this.getColuna(); j++) {
                x = this.getLinha() - i - 1;
                y = j;
                this.matriz2[y][x] = this.matriz[i][j];

            }
        }
        return this.matriz2;
    }

    public int[][] Girar90neg(int[][] image) throws FileNotFoundException {

        int x = 0;
        int y = 0;
        this.matriz2 = new int[this.getLinha()][this.getColuna()];
        for (int i = 0; i < this.getLinha(); i++) {
            for (int j = 0; j < this.getColuna(); j++) {
                x = i;
                y = this.getColuna() - 1 - j;
                this.matriz2[y][x] = this.matriz[i][j];

            }
        }
        return this.matriz2;
    }

    public int[][] Girar180(int[][] image) throws FileNotFoundException {
        /*
    int width = image[0].length;
    int height = image.length;
         */
        //int[][] result = new int[height][width];
        int x = 0;
        int y = 0;
        this.matriz2 = new int[this.getLinha()][this.getColuna()];
        this.setMatriz2(matriz2);
        for (int i = 0; i < this.getLinha(); i++) {
            for (int j = 0; j < this.getColuna(); j++) {
                x = this.getColuna() - 1 - j;
                y = this.getLinha() - 1 - i;
                this.matriz2[y][x] = this.matriz[i][j];

            }
        }
        return this.matriz2;
    }

    public int[][] espelharHorizontal(int[][] matriz) {

        int x = 0;
        int y = 0;
        this.matriz2 = new int[this.getLinha()][this.getColuna()];
        this.setMatriz2(matriz2);
        for (int i = 0; i < this.getLinha(); i++) {
            for (int j = 0; j < this.getColuna(); j++) {
                x = this.getColuna() - 1 - j;
                y = i;
                this.matriz2[y][x] = this.matriz[i][j];
            }
        }
        return this.matriz2;
    }

    public int[][] espelharVertical(int[][] matriz) {

        int x = 0;
        int y = 0;
        this.matriz2 = new int[this.getLinha()][this.getColuna()];
        this.setMatriz2(matriz2);
        for (int i = 0; i < this.getLinha(); i++) {
            for (int j = 0; j < this.getColuna(); j++) {
                x = j;
                y = this.getLinha() - 1 - i;
                this.matriz2[y][x] = this.matriz[i][j];
            }
        }
        return this.matriz2;
    }

    


    public int[][] ReduzirTonsCinza(int[][] image, int valor) {

        int divisor = 256 / valor;
        for (int i = 0; i < this.getLinha(); ++i) {
            for (int j = 0; j < this.getColuna(); ++j) {

                this.matriz[i][j] = this.matriz[i][j] / divisor;

            }
        }
        return this.matriz;
    }

    
    
    public int[][] RealcarIntervalo(int[][] matriz, int intervalo1, int intervalo2, int valor) {

        for (int i = 0; i < this.getLinha(); i++) {
            for (int j = 0; j < this.getColuna(); j++) {
                if (matriz[i][j] >= intervalo1 && matriz[i][j] <= intervalo2) {
                    matriz[i][j] = valor;
                }
            }
        }

        return this.matriz;
    }

    public int[][] RealcarIntervalo2(int[][] matriz, int intervalo1, int intervalo2, int valor, int valor2) {

        for (int i = 0; i < this.getLinha(); i++) {
            for (int j = 0; j < this.getColuna(); j++) {
                if (matriz[i][j] >= intervalo1 && matriz[i][j] <= intervalo2) {
                    matriz[i][j] = valor;
                } else {
                    matriz[i][j] = valor2;
                }
            }
        }

        return this.matriz;
    }

     public int[][] transformarPotencia(int[][] Matriz, float gama) {
        
        this.matriz2 = new int[this.getLinha()][this.getColuna()];
        for (int i = 0; i < this.getLinha(); i++)
            for (int j = 0; j < this.getColuna(); j++) {
                float v = (float)Math.pow((this.matriz[i][j]/255.0f), gama);
                int r = Math.round(v*255);
                if (r < 0)
                    r = 0;
                else
                    if (r > 255)
                        r = 255;
                this.matriz2[i][j]=r;
            }
        return this.matriz2;
    }
    
    
    public int[][] Zoom(int[][] matriz, int n) {

        this.matriz2 = new int[this.getLinha() * n][this.getColuna() * n];
        this.setMatriz2(this.matriz2);
        this.setLinha2(this.getLinha() * n);
        this.setColuna2(this.getColuna() * n);
        int aux = 0;

        for (int i = 0; i < this.getLinha(); i++) {

            for (int j = 0; j < this.getColuna(); j++) {
                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < n; l++) {
                        this.matriz2[i * n + k][j * n + l] = this.matriz[i][j];
                    }
                }

            }

        }
        return this.matriz2;

    }

    public int[][] Minimizar(int[][] matriz, int n) {

        this.matriz2 = new int[this.getLinha() / n][this.getColuna() / n];
        this.setMatriz2(this.matriz2);
        this.setLinha2(this.getLinha() / n);
        this.setColuna2(this.getColuna() / n);
        int aux = 0;

        for (int i = 0; i < this.getLinha2(); i++) {

            for (int j = 0; j < this.getColuna2(); j++) {
                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < n; l++) {
                        aux += this.matriz[k + i*n][l + j*n];

                    }
                }

                aux /= n*n;
                if (aux > 255) {
                    this.matriz2[i][j] = 255;
                } else {
                    this.matriz2[i][j] = aux;
                }
                aux = 0;
            }

        }
        return this.matriz2;

    }
    
    
    public int[][] extrair_RGB(String arq,int[][]matriz)throws FileNotFoundException, IOException {
        
       if(this.getMagic_number().equals("P3")){
        
            int cont =0;
                 while(cont<3){
                 JFileChooser fc = new JFileChooser("C:\\Users\\akume\\Desktop\\PDI_Atividade_1_Interface\\imagem");
                 String filename = null;
                  int result;
                  result = fc.showOpenDialog(null);
                  if (result == javax.swing.JFileChooser.APPROVE_OPTION) {
                  filename = fc.getSelectedFile().getAbsolutePath();
                  this.setArquivo(fc.getSelectedFile());

                  Scanner scanner = null;
                  try {
                      scanner = new Scanner(new File(filename));
                      scanner.useLocale(Locale.ROOT);
                  } catch (FileNotFoundException ex) {
                      Logger.getLogger(PDI_Atividade_1.class.getName()).log(Level.SEVERE, null, ex);
                  }
              }

              OutputStream os = new FileOutputStream(filename);

              OutputStreamWriter osw = new OutputStreamWriter(os);

              BufferedWriter bw = new BufferedWriter(osw);

              Scanner entrada = new Scanner(new File(arq));


              String aux= entrada.next();
              bw.write("P2" + "\r\n"); // magic number
              bw.write(entrada.next() + " ");
              bw.write(entrada.next() + "\r\n");
              bw.write(entrada.next() + "\r\n");


              for (int i = 0; i < this.getLinha(); i++) {
                  for (int j = 0; j < this.getColuna(); j++) {
                      //String linha = entrada.nextLine();
                      if(cont==0){
                      String newlinha = Integer.toString(this.matrizR[i][j]);
                      try {
                          bw.write(newlinha);
                      } catch (IOException ex) {
                          Logger.getLogger(PDI_Atividade_1.class.getName()).log(Level.SEVERE, null, ex);
                      }
                      try {
                          bw.newLine();
                      } catch (IOException ex) {
                          Logger.getLogger(PDI_Atividade_1.class.getName()).log(Level.SEVERE, null, ex);
                      }
                      }else if(cont==1){
                          String newlinha = Integer.toString(this.matrizG[i][j]);
                      try {
                          bw.write(newlinha);
                      } catch (IOException ex) {
                          Logger.getLogger(PDI_Atividade_1.class.getName()).log(Level.SEVERE, null, ex);
                      }
                      try {
                          bw.newLine();
                      } catch (IOException ex) {
                          Logger.getLogger(PDI_Atividade_1.class.getName()).log(Level.SEVERE, null, ex);
                      }

                      }else if(cont==2){
                          String newlinha = Integer.toString(this.matrizB[i][j]);
                      try {
                          bw.write(newlinha);
                      } catch (IOException ex) {
                          Logger.getLogger(PDI_Atividade_1.class.getName()).log(Level.SEVERE, null, ex);
                      }
                      try {
                          bw.newLine();
                      } catch (IOException ex) {
                          Logger.getLogger(PDI_Atividade_1.class.getName()).log(Level.SEVERE, null, ex);
                          }
                      }

                  }

              }
             
              cont++;
              try {
                  bw.close();
                  } catch (IOException ex) {
                      Logger.getLogger(PDI_Atividade_1.class.getName()).log(Level.SEVERE, null, ex);
                  }
                  entrada.close();
                  //cont++;
                  }
                  
             }
             return matriz;
    }

    
    public int[][] filtroMedia(int[][] matriz,int dim){ //Função que aplica um filtro da média numa imagem
        
        this.matriz2 = new int[this.getLinha()+dim-1][this.getColuna()+dim-1];
        this.setMatriz2(this.matriz2);
        this.setLinha2(this.getLinha()+dim-1);
        this.setColuna2(this.getColuna()+dim-1);
        for(int i = 0; i < this.getLinha(); i++){
            for(int j = 0; j < this.coluna; j++){
                this.matriz2[i + dim/2][j + dim/2] = matriz[i][j]; 
            }
        }
        
        this.matriz3 = new int[this.getLinha()][this.getColuna()];
        for(int i = 0; i <this.getLinha(); i++){
            for(int j = 0; j < this.getColuna(); j++){
                float aux = 0;
                for(int k = 0; k < dim; k++){
                    for(int l =0; l < dim; l++){
                        aux += this.matriz2[i + k][j + 1];
                    }
                }
                if(aux/(dim*dim) > 255){
                    this.matriz3[i][j] = 255;
                }else if(aux/(dim*dim) < 0){
                    this.matriz3[i][j] = 0;
                }else{
                    this.matriz3[i][j] = (int)Math.round(aux/(dim*dim));
                }
            }
        }
        
        
        for(int i = 0; i < this.getLinha(); i++){
            for(int j = 0; j < this.getColuna(); j++){
                matriz[i][j] = this.matriz3[i][j];
            }
        }
    
        return matriz;
    }
    
    
    
    public int[][] filtroMediano(int[][] matriz,int dim){ //Função que aplica um filtro da média numa imagem
        
        
        this.matriz2 = new int[this.getLinha()+(dim-1)][this.getColuna()+(dim-1)];
        this.setMatriz2(this.matriz2);
        this.setLinha2(this.getLinha()+(dim-1));
        this.setColuna2(this.getColuna()+(dim-1));
        for(int i = 0; i < this.getLinha(); i++){
            for(int j = 0; j < this.coluna; j++){
                this.matriz2[i + dim/2][j + dim/2] = matriz[i][j]; 
            }
        }
        
        this.matriz3 = new int[this.getLinha()][this.getColuna()];
        for(int i = 0; i <this.getLinha(); i++){
            for(int j = 0; j < this.getColuna(); j++){
                ArrayList<Integer> aux;
               aux= new ArrayList();
                for(int k = 0; k < dim; k++){
                    for(int l =0; l < dim; l++){
                        aux.add( this.matriz2[i + k][j + 1]);
                    }
                }
                Collections.sort(aux);
                    int aux2=(dim*dim)/2+1;
                    this.matriz3[i][j] = aux.get(aux2);
                    
                }
            }
        
 
        
        for(int i = 0; i < this.getLinha(); i++){
            for(int j = 0; j < this.getColuna(); j++){
                matriz[i][j] = this.matriz3[i][j];
            }
        }
    
        return matriz;
    }
    
    
    public int[][] filtroMediano5x5(int[][] matriz){ //Função que aplica um filtro da média numa imagem
        
        
        this.matriz2 = new int[this.getLinha()+4][this.getColuna()+4];
        this.setMatriz2(this.matriz2);
        this.setLinha2(this.getLinha()+4);
        this.setColuna2(this.getColuna()+4);
        for(int i = 0; i < this.getLinha(); i++){
            for(int j = 0; j < this.coluna; j++){
                this.matriz2[i + 2][j + 2] = matriz[i][j]; 
            }
        }
        
        this.matriz3 = new int[this.getLinha()+4][this.getColuna()+4];
        for(int i = 0; i <this.getLinha(); i++){
            for(int j = 0; j < this.getColuna(); j++){
                ArrayList<Integer> aux;
               aux= new ArrayList();
                for(int k = 0; k < 5; k++){
                    for(int l =0; l < 5; l++){
                        aux.add( this.matriz2[i + k][j + 1]);
                    }
                }
                Collections.sort(aux);
                
                    this.matriz3[i][j] = (int)Math.round(aux.get(13));
                    
                }
            }
        
 
        
        for(int i = 0; i < this.getLinha(); i++){
            for(int j = 0; j < this.getColuna(); j++){
                matriz[i][j] = this.matriz3[i+2][j+2];
            }
        }
    
        return matriz;
    }
    
    
    
    public int[][] filtroLaplaciano(int[][] matriz,int filtro,int tipo){ //Função que aplica um filtro da média numa imagem
        int[][] filtro1 = {{0,-1,0},{-1,4,-1},{0,-1,0}};
        int[][] filtro2 = {{-1,-1,-1},{-1,8,-1},{-1,-1,-1}};
        int[][] filtro0;
        this.matriz2 = new int[this.getLinha()+2][this.getColuna()+2];
        this.setMatriz2(this.matriz2);
        this.setLinha2(this.getLinha()+2);
        this.setColuna2(this.getColuna()+2);
        int aux=0;
        int aux1=0;
        int aux2=0;
        double aux4=0;
        
        
        for(int i = 0; i < this.getLinha(); i++){
            for(int j = 0; j < this.coluna; j++){
                this.matriz2[i + 1][j + 1] = matriz[i][j]; 
            }
        }
        
        
        
        if(filtro==0){
              filtro0=filtro1;
        }else{
            filtro0=filtro2;
        }
        int distancia=(filtro0.length)/2;
        this.matriz3 = new int[this.getLinha()+2][this.getColuna()+2];
        for(int i = distancia; i <this.getLinha()-distancia; i++){
            for(int j = distancia; j < this.getColuna()-distancia; j++){
                aux=-distancia;
                aux1=aux;
                for(int k = 0; k <(distancia*2)+1; k++){
                    aux2=aux;
                    for(int l =0; l <(distancia*2)+1; l++){
                        aux4 += (int)(this.matriz2[i+aux1][j+aux2] * filtro1[k][l]);
                        aux2++;
                    }
                    aux1++;
                }
               if(aux4 > 255){
                    this.matriz3[i][j] = 255;
                    aux4=0;
                
                }else{
                    this.matriz3[i][j] = Math.abs((int)Math.round(aux4));
                    aux4=0;
                }
            }
        }
        
        double menor=999999;
        
        for(int i = 0; i < this.getLinha(); i++){
            for(int j = 0; j < this.getColuna(); j++){
                if(this.matriz3[i][j]<menor){
                    menor=this.matriz3[i][j];
                }
            }
        }
    
        
        for(int i = 0; i < this.getLinha(); i++){
            for(int j = 0; j < this.getColuna(); j++){
                if(this.matriz2[i+1][j+1]+this.matriz3[i+1][j+1]+Math.abs((int)Math.round(menor))>255){
                   matriz[i][j] =255; 
                }else{
                matriz[i][j] =this.matriz2[i+1][j+1]+this.matriz3[i+1][j+1]+Math.abs((int)Math.round(menor));
                }
            }
        }
    
        return matriz;
    }
    
    
    public int[][] equalizacaoHistograma(int[][] matriz){ //Função que aplica uma equalização utilizando um histograma
        
        int[] histograma= new int[256];
          for(int i=0;i<this.getLinha();i++){
              for(int j=0;j<this.getColuna();j++){
                  histograma[this.matriz[i][j]]++;
              }
          }
        double[] eqHistograma = new double[histograma.length];
        int nDePixels = this.getLinha()*this.getColuna(); //contém o numero total de pixels
        double aux =0;
        
        //descobre o numero equivalente no histograma para fazer depois a transformação de equalização
        for(int i = 0; i < eqHistograma.length; i++){
            aux += ((double)histograma[i] / (double)nDePixels);
            eqHistograma[i] = (255)*(aux);
        }
        
        this.matriz2 = new int[this.getLinha()][this.getColuna()];
        for(int i = 0; i <this.getLinha(); i++){
            for(int j = 0; j < this.getColuna(); j++){
                this.matriz2 [i][j] = (int)Math.round(eqHistograma[matriz[i][j]]);
            }
        }
        
        for(int i=0;i<256;i++){
            System.out.println(" " + eqHistograma[i]);
        }
        return this.matriz2;
    }
    
    public int[][] Filtro_HighBoost(int[][] matriz,int dim){
        
        this.matriz2 = new int[this.getLinha()+dim-1][this.getColuna()+dim-1];
        this.setMatriz2(this.matriz2);
        this.setLinha2(this.getLinha()+dim-1);
        this.setColuna2(this.getColuna()+dim-1);
        
        for(int i = 0; i < this.getLinha(); i++){
            for(int j = 0; j < this.coluna; j++){
                this.matriz2[i + dim/2][j + dim/2] = this.matriz[i][j]; 
            }
        }
        
        this.matriz3 = new int[this.getLinha()][this.getColuna()];
        for(int i = 0; i <this.getLinha(); i++){
            for(int j = 0; j < this.getColuna(); j++){
                float aux = 0;
                for(int k = 0; k < dim; k++){
                    for(int l =0; l < dim; l++){
                        aux += this.matriz2[i + k][j + 1];
                    }
                }
                if(aux/(dim*dim) > 255){
                    this.matriz3[i][j] = 255;
                }else if(aux/(dim*dim) < 0){
                    this.matriz3[i][j] = 0;
                }else{
                    this.matriz3[i][j] = (int)Math.round(aux/(dim*dim));
                }
            }
        }
        
        
        for(int i = 0; i < this.getLinha(); i++){
            for(int j = 0; j < this.getColuna(); j++){
                matriz[i][j] = Math.abs(this.matriz[i][j]-this.matriz3[i][j]);
                
            }
        }
        
        
        double k=1.2;
        for(int i = 0; i < this.getLinha(); i++){
            for(int j = 0; j < this.getColuna(); j++){
                this.matriz[i][j] = (int)Math.round(this.matriz[i][j]+(matriz[i][j]*k));
                 if(this.matriz[i][j]>255){
                    this.matriz[i][j]=255;
                }
            }
        }
        
        return this.matriz;
    }
    
    
    
    
    
    
    
      public int[][] juntar_RGB(String arq,int[][]matriz,int[][]matriz2,int[][]matriz3)throws FileNotFoundException, IOException {
        
                if(this.matrizR==null || this.matrizG==null || this.matrizB ==null){

                      for(int i=0;i<3;i++){
                        this.ler_arquivo();
                         if(i==0){
                             this.matrizR = new int[this.getLinha()][this.getColuna()];
                             this.setMatrizR(this.matriz);

                         }else if(i==1){
                             this.matrizG = new int[this.getLinha()][this.getColuna()];
                             this.setMatrizG(this.matriz);
                         }
                         else if(i==2){
                             this.matrizB = new int[this.getLinha()][this.getColuna()];
                             this.setMatrizB(this.matriz);
                         }
                      }

                }
          
           
                
                 
                 
                  JFileChooser fc = new JFileChooser("C:\\Users\\akume\\Desktop\\PDI_Atividade_1_Interface\\imagem");
                  String filename = null;
                  int result;
                  result = fc.showOpenDialog(null);
                  if (result == javax.swing.JFileChooser.APPROVE_OPTION) {
                  filename = fc.getSelectedFile().getAbsolutePath();
                  this.setArquivo(fc.getSelectedFile());

                  Scanner scanner = null;
                        try {
                            scanner = new Scanner(new File(filename));
                            scanner.useLocale(Locale.ROOT);
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(PDI_Atividade_1.class.getName()).log(Level.SEVERE, null, ex);
                        }
              }

              OutputStream os = new FileOutputStream(filename);

              OutputStreamWriter osw = new OutputStreamWriter(os);

              BufferedWriter bw = new BufferedWriter(osw);

              Scanner entrada = new Scanner(new File(arq));


              String aux= entrada.next();
              bw.write("P3" + "\r\n"); // magic number
              bw.write(entrada.next() + " ");
              bw.write(entrada.next() + "\r\n");
              bw.write(entrada.next() + "\r\n");


              for (int i = 0; i < this.getLinha(); i++) {
                  for (int j = 0; j < this.getColuna(); j++) {
                      //String linha = entrada.nextLine();
                      
                            String newlinha = Integer.toString(this.matrizR[i][j]);
                            String newlinha1 = Integer.toString(this.matrizG[i][j]);
                            String newlinha2 = Integer.toString(this.matrizB[i][j]);
                            try {
                                bw.write(newlinha + " ");
                                bw.write(newlinha1 + " ");
                                bw.write(newlinha2 + " ");
                            } catch (IOException ex) {
                                Logger.getLogger(PDI_Atividade_1.class.getName()).log(Level.SEVERE, null, ex);
                            }
                      
                      try {
                          bw.newLine();
                      } catch (IOException ex) {
                          Logger.getLogger(PDI_Atividade_1.class.getName()).log(Level.SEVERE, null, ex);
                      }
                    

                  }

              }
            
              try {
                  bw.close();
                  } catch (IOException ex) {
                      Logger.getLogger(PDI_Atividade_1.class.getName()).log(Level.SEVERE, null, ex);
                  }
                  entrada.close();
                  //cont++;
                  
                  
             
             return matriz;
    }

 
    public int[][] alterar_arquivo(String arq, int[][] matriz) throws FileNotFoundException, IOException {

        //Quando for testar, por favor mudar para o diretório apropriado
        JFileChooser fc = new JFileChooser("C:\\Users\\akume\\Desktop\\PDI_Atividade_1_Interface\\imagem");
        String filename = null;
        int result;
        result = fc.showOpenDialog(null);
        if (result == javax.swing.JFileChooser.APPROVE_OPTION) {
            filename = fc.getSelectedFile().getAbsolutePath();
            this.setArquivo(fc.getSelectedFile());

            Scanner scanner = null;
            try {
                scanner = new Scanner(new File(filename));
                scanner.useLocale(Locale.ROOT);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(PDI_Atividade_1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        OutputStream os = new FileOutputStream(filename);

        OutputStreamWriter osw = new OutputStreamWriter(os);

        BufferedWriter bw = new BufferedWriter(osw);

        Scanner entrada = new Scanner(new File(arq));
        
        if(this.isFlag()){
        
                bw.write(entrada.next() + "\r\n"); // magic number
                bw.write(entrada.next() + " ");
                bw.write(entrada.next() + " ");
                bw.write(entrada.next() + " ");
                bw.write(entrada.next() + "\r\n");
                bw.write(entrada.next() + " ");
                bw.write(entrada.next() + "\r\n");
                bw.write(entrada.next() + "\r\n");
        }else{
                bw.write(entrada.next() + "\r\n"); // magic number
                bw.write(entrada.next() + " ");
                bw.write(entrada.next() + "\r\n");
                bw.write(entrada.next() + "\r\n");

        }
        for (int i = 0; i < this.getLinha(); i++) {
            for (int j = 0; j < this.getColuna(); j++) {
                //String linha = entrada.nextLine();
                String newlinha = Integer.toString(matriz[i][j]);
                try {
                    bw.write(newlinha);
                } catch (IOException ex) {
                    Logger.getLogger(PDI_Atividade_1.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    bw.newLine();
                } catch (IOException ex) {
                    Logger.getLogger(PDI_Atividade_1.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
        //}
        try {
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(PDI_Atividade_1.class.getName()).log(Level.SEVERE, null, ex);
        }
        entrada.close();
        return matriz;
    }

    public int[][] alterar_arquivo_2(String arq, int[][] matriz) throws FileNotFoundException, IOException {

        JFileChooser fc = new JFileChooser("C:\\Users\\akume\\Desktop\\PDI_Atividade_1_Interface\\imagem");
        String filename = null;
        int result;
        result = fc.showOpenDialog(null);
        if (result == javax.swing.JFileChooser.APPROVE_OPTION) {
            filename = fc.getSelectedFile().getAbsolutePath();
            this.setArquivo(fc.getSelectedFile());

            Scanner scanner = null;
            try {
                scanner = new Scanner(new File(filename));
                scanner.useLocale(Locale.ROOT);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(PDI_Atividade_1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        OutputStream os = new FileOutputStream(filename);

        OutputStreamWriter osw = new OutputStreamWriter(os);

        BufferedWriter bw = new BufferedWriter(osw);

        Scanner entrada = new Scanner(new File(arq));

        
        if(this.isFlag()){
            
            if(this.isFlag()){
        
                bw.write(entrada.next() + "\r\n"); // magic number
                bw.write(entrada.next() + " ");
                bw.write(entrada.next() + " ");
                bw.write(entrada.next() + " ");
                bw.write(entrada.next() + "\r\n");
                bw.write(this.getLinha2() + " ");
                bw.write(this.getColuna2() + "\r\n");
                bw.write(entrada.next() + "\r\n");
        }
        
            else{
                bw.write(entrada.next() + "\r\n"); // magic number
                bw.write(this.getLinha2() + " ");
                bw.write(this.getColuna2() + "\r\n");
                bw.write(entrada.next() + "\r\n");
            }
        //this.matriz = new int[height][width];
        //this.setLinha(height);
        //this.setColuna(width);
        //while (entrada.hasNextLine()) {
        for (int i = 0; i < this.getLinha2(); i++) {
            for (int j = 0; j < this.getColuna2(); j++) {
                //String linha = entrada.nextLine();
                String newlinha = Integer.toString(matriz[i][j]);
                try {
                    bw.write(newlinha);
                } catch (IOException ex) {
                    Logger.getLogger(PDI_Atividade_1.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    bw.newLine();
                } catch (IOException ex) {
                    Logger.getLogger(PDI_Atividade_1.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
        //}
        try {
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(PDI_Atividade_1.class.getName()).log(Level.SEVERE, null, ex);
        }
        entrada.close();

        
        }
        return matriz;
    }
    public int[][] alterar_arquivo_tons_cinza(String arq, int[][] matriz, int valor) throws FileNotFoundException, IOException {

        //InputStream is = new FileInputStream("e:/teste.txt");
        JFileChooser fc = new JFileChooser("C:\\Users\\akume\\Desktop\\PDI_Atividade_1_Interface\\imagem");
        String filename = null;
        int result;
        result = fc.showOpenDialog(null);
        if (result == javax.swing.JFileChooser.APPROVE_OPTION) {
            filename = fc.getSelectedFile().getAbsolutePath();
            this.setArquivo(fc.getSelectedFile());

            Scanner scanner = null;
            try {
                scanner = new Scanner(new File(filename));
                scanner.useLocale(Locale.ROOT);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(PDI_Atividade_1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        OutputStream os = new FileOutputStream(filename);

        OutputStreamWriter osw = new OutputStreamWriter(os);

        BufferedWriter bw = new BufferedWriter(osw);

        Scanner entrada = new Scanner(new File(arq));
        
        
        if(this.isFlag()){
        
                bw.write(entrada.next() + "\r\n"); // magic number
                bw.write(entrada.next() + " ");
                bw.write(entrada.next() + " ");
                bw.write(entrada.next() + " ");
                bw.write(entrada.next() + "\r\n");
                bw.write(entrada.next() + " ");
                bw.write(entrada.next() + "\r\n");
                bw.write(valor + "\r\n");
        }else{
                bw.write(entrada.next() + "\r\n"); // magic number
                bw.write(entrada.next() + " ");
                bw.write(entrada.next() + "\r\n");
                bw.write(valor + "\r\n");

        }
        

        //this.matriz = new int[height][width];
        //this.setLinha(height);
        //this.setColuna(width);
        //while (entrada.hasNextLine()) {
        for (int i = 0; i < this.getLinha(); i++) {
            for (int j = 0; j < this.getColuna(); j++) {
                //String linha = entrada.nextLine();
                String newlinha = Integer.toString(matriz[i][j]);
                try {
                    bw.write(newlinha);
                } catch (IOException ex) {
                    Logger.getLogger(PDI_Atividade_1.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    bw.newLine();
                } catch (IOException ex) {
                    Logger.getLogger(PDI_Atividade_1.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
        //}
        try {
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(PDI_Atividade_1.class.getName()).log(Level.SEVERE, null, ex);
        }
        entrada.close();

        return matriz;
    }

    public int[][] Somar_Matriz() {

        for (int linha = 0; linha < this.getLinha(); linha++) {
            for (int coluna = 0; coluna < this.getColuna(); coluna++) {
                Scanner entrada = new Scanner(System.in);
                System.out.printf("Digite o elemento M[%d][%d]: ", linha + 1, coluna + 1);
                matriz[linha][coluna] = entrada.nextInt();
            }
        }

        for (int linha = 0; linha < this.getLinha(); linha++) {
            for (int coluna = 0; coluna < this.getColuna(); coluna++) {
                Scanner entrada = new Scanner(System.in);
                System.out.printf("Digite o elemento M[%d][%d]: ", linha + 1, coluna + 1);
                matriz2[linha][coluna] = entrada.nextInt();
            }
        }

        for (int linha = 0; linha < this.getLinha(); linha++) {
            for (int coluna = 0; coluna < this.getColuna(); coluna++) {
                soma[linha][coluna] = matriz[linha][coluna] + matriz2[linha][coluna];
                System.out.println("os elementos da matriz resultante são : " + soma[linha][coluna]);
            }
        }

        return soma;
    }

    public int[][] binarização(int[][] image, int valor) throws FileNotFoundException {

        for (int i = 0; i < this.getLinha(); ++i) {
            for (int j = 0; j < this.getColuna(); ++j) {
                if (this.matriz[i][j] < valor) {
                    this.matriz[i][j] = 0;
                } else if (this.matriz[i][j] > valor) {
                    this.matriz[i][j] = 255;
                }
            }
        }
        return this.matriz;
    }

    

}
