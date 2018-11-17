/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Locacao;

import DAO.*;
import Modelo.*;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cliente
 */
public class Locacao extends javax.swing.JFrame {

    /**
     * Creates new form Locacao
     */
    public Locacao() {
        initComponents();
        setLocationRelativeTo(this);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        AtualizaCombo();
        AtualizaTable();
    }
    
    public void AtualizaTable() {
        
        Connection con = Conexao.AbrirConexao();
        AluguelDAO bd = new AluguelDAO(con);
        List<Aluguel> lista = new ArrayList<>();
        lista = bd.ListarAluguel();
        
        DefaultTableModel tbm = (DefaultTableModel) jTable1.getModel();
        
        while (tbm.getRowCount() > 0) {
            
            tbm.removeRow(0);
            
        }

        int i = 0;
        for (Aluguel tab : lista) {
            
            tbm.addRow(new String[i]);
            jTable1.setValueAt(tab.getCod(), i, 0);
            jTable1.setValueAt(tab.getCoddvd(), i, 1);
            jTable1.setValueAt(tab.getCodcliente(), i, 2);
            jTable1.setValueAt(tab.getHorario(), i, 3);
            jTable1.setValueAt(tab.getData_aluguel(), i, 4);
            jTable1.setValueAt(tab.getData_devolucao(), i, 5);
            
            i++;
            
        }
        
        Conexao.FecharConexao(con);
        
    }
    
    public void PesquisarCod() {
        
        Connection con = Conexao.AbrirConexao();
        AluguelDAO bd = new AluguelDAO(con);
        List<Aluguel> lista = new ArrayList<>();
        lista = bd.PesquisarCodAluguel(Integer.parseInt(jTf_a.getText()));
        
        DefaultTableModel tbm = (DefaultTableModel) jTable1.getModel();
        
        while (tbm.getRowCount() > 0) {
            
            tbm.removeRow(0);
            
        }

        int i = 0;
        for (Aluguel tab : lista) {
            
            tbm.addRow(new String[i]);
            jTable1.setValueAt(tab.getCod(), i, 0);
            jTable1.setValueAt(tab.getCoddvd(), i, 1);
            jTable1.setValueAt(tab.getCodcliente(), i, 2);
            jTable1.setValueAt(tab.getHorario(), i, 3);
            jTable1.setValueAt(tab.getData_aluguel(), i, 4);
            jTable1.setValueAt(tab.getData_devolucao(), i, 5);
            
            i++;
            
        }
        
        Conexao.FecharConexao(con);
        
    }
    
    public void PesquisarCodDVD() {
        
        Connection con = Conexao.AbrirConexao();
        AluguelDAO bd = new AluguelDAO(con);
        List<Aluguel> lista = new ArrayList<>();
        lista = bd.PesquisarCodDVD(Integer.parseInt(jTF_b.getText()));
        
        DefaultTableModel tbm = (DefaultTableModel) jTable1.getModel();
        
        while (tbm.getRowCount() > 0) {
            
            tbm.removeRow(0);
            
        }

        int i = 0;
        for (Aluguel tab : lista) {
            
            tbm.addRow(new String[i]);
            jTable1.setValueAt(tab.getCod(), i, 0);
            jTable1.setValueAt(tab.getCoddvd(), i, 1);
            jTable1.setValueAt(tab.getCodcliente(), i, 2);
            jTable1.setValueAt(tab.getHorario(), i, 3);
            jTable1.setValueAt(tab.getData_aluguel(), i, 4);
            jTable1.setValueAt(tab.getData_devolucao(), i, 5);
            
            i++;
            
        }
        
        Conexao.FecharConexao(con);
        
    }
    
    public void PesquisarCodCliente() {
        
        Connection con = Conexao.AbrirConexao();
        AluguelDAO bd = new AluguelDAO(con);
        List<Aluguel> lista = new ArrayList<>();
        lista = bd.PesquisarCodCliente(Integer.parseInt(JTf_c.getText()));
        
        DefaultTableModel tbm = (DefaultTableModel) jTable1.getModel();
        
        while (tbm.getRowCount() > 0) {
            
            tbm.removeRow(0);
            
        }

        int i = 0;
        for (Aluguel tab : lista) {
            
            tbm.addRow(new String[i]);
            jTable1.setValueAt(tab.getCod(), i, 0);
            jTable1.setValueAt(tab.getCoddvd(), i, 1);
            jTable1.setValueAt(tab.getCodcliente(), i, 2);
            jTable1.setValueAt(tab.getHorario(), i, 3);
            jTable1.setValueAt(tab.getData_aluguel(), i, 4);
            jTable1.setValueAt(tab.getData_devolucao(), i, 5);
            
            i++;
            
        }
        
        Conexao.FecharConexao(con);
        
    }
    
    public void AtualizaDate() {
        
        Date date = new Date();
        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat hora = new SimpleDateFormat("hh:mm");
        jTF_DataLocacao.setText(data.format(date));
        jTF_Horas.setText(hora.format(date));
        
    }

    public void AtualizaCombo(){
        
        Connection con = Conexao.AbrirConexao();
        ClienteDAO sql = new ClienteDAO(con);
        List<Cliente> lista = new ArrayList<>();
        
        lista = sql.ListarComboCliente();
        ComboCliente.addItem(" - ");
        
        for (Cliente b : lista) {
            
            ComboCliente.addItem(b.getNome());
                
        }
        
        Conexao.FecharConexao(con);
        
    }
    
    public void SelecionarCombo(){
        
        Connection con = Conexao.AbrirConexao();
        ClienteDAO sql = new ClienteDAO(con);
        List<Cliente> lista = new ArrayList<>();
        String nome = ComboCliente.getSelectedItem().toString();
        
        lista = sql.ConsultaCodigoCliente(nome);
        
        for (Cliente b : lista) {
            
            int a = b.getCodigo();
            jTF_CodCliente.setText(""+a);
                
        }
        
        Conexao.FecharConexao(con);
        
    }
    
    private void InserirDados(int cod){
        
        Connection con = Conexao.AbrirConexao();
        DVDDAO dvd = new DVDDAO(con);
        FilmeDAO filme = new FilmeDAO(con);
        
        List<DVD> listaDVD = new ArrayList<>();
        List<Filme> listaFIL = new ArrayList<>();
        
        listaDVD = dvd.ListarCodFilme(cod);
        
        for (DVD a : listaDVD) {
            
            int codigo = a.getCod_filme();
            listaFIL = filme.Pesquisa_Cod_Filme(codigo);
            
        }
        
        for (Filme a : listaFIL) {
            
            jTF_Titulo.setText(a.getTitulo());
            jTF_Categoria.setText("" + a.getCod_categoria());
            jTF_Classificacao.setText("" + a.getCod_classificacao());
            lbCapa.setIcon(new ImageIcon("ImagensFilme/" + a.getCapa() + "/"));
            
        }
        
        ClassificacaoDAO cla = new ClassificacaoDAO(con);
        List<Classificacao> listaCLA = new ArrayList<>();
        
        String b = jTF_Classificacao.getText();
        int codigo = Integer.parseInt(b);
        
        listaCLA = cla.ListarPrecoClassificacao(codigo);
        
        for (Classificacao a : listaCLA) {
            
            double preco = a.getPreco();
            jTF_Aluguel.setText(""+preco+"0");
            
        }
        
        Conexao.FecharConexao(con);
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jTF_CodDVD = new javax.swing.JTextField();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel12 = new javax.swing.JLabel();
        jTF_CodigoDVD = new javax.swing.JTextField();
        jTF_Horas = new javax.swing.JFormattedTextField();
        jLabel13 = new javax.swing.JLabel();
        jTF_Titulo = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTF_Classificacao = new javax.swing.JTextField();
        Categoria = new javax.swing.JLabel();
        jTF_Categoria = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTF_Aluguel = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jTF_CodCliente = new javax.swing.JTextField();
        ComboCliente = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jTF_DataLocacao = new javax.swing.JFormattedTextField();
        jTF_DataDevolucao = new com.toedter.calendar.JDateChooser();
        jLabel19 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        lbCapa = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jTf_a = new javax.swing.JTextField();
        jToggleButton2 = new javax.swing.JToggleButton();
        jLabel21 = new javax.swing.JLabel();
        jTF_b = new javax.swing.JTextField();
        jToggleButton3 = new javax.swing.JToggleButton();
        jLabel22 = new javax.swing.JLabel();
        JTf_c = new javax.swing.JTextField();
        jToggleButton4 = new javax.swing.JToggleButton();
        jToggleButton5 = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Cod DVD");

        jToggleButton1.setText("OK");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Horas");

        try {
            jTF_Horas.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Titulo");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Classificação");

        Categoria.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Categoria.setText("Categoria");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Valor de aluguel");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Cliente");

        jTF_CodCliente.setEditable(false);

        ComboCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboClienteActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Data da Locação");

        try {
            jTF_DataLocacao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jTF_DataLocacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTF_DataLocacaoActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Data da Devolução");

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));

        jButton3.setText("Cadastrar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Cancelar");

        jButton5.setText("Limpar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(227, 227, 227)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        lbCapa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/DVD_VIDEO_logo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTF_CodDVD, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(182, 182, 182)
                        .addComponent(jTF_CodigoDVD, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTF_Horas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTF_Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTF_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jTF_Classificacao, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jTF_Aluguel, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTF_CodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(ComboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTF_DataLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jTF_DataDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(lbCapa)
                .addGap(0, 13, Short.MAX_VALUE))
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(4, 4, 4)
                            .addComponent(jLabel11)
                            .addGap(37, 37, 37)
                            .addComponent(jLabel13)
                            .addGap(29, 29, 29)
                            .addComponent(Categoria)
                            .addGap(29, 29, 29)
                            .addComponent(jLabel17)
                            .addGap(29, 29, 29)
                            .addComponent(jLabel18))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTF_CodDVD, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTF_CodigoDVD, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(4, 4, 4)
                                    .addComponent(jLabel12))
                                .addComponent(jTF_Horas, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(26, 26, 26)
                            .addComponent(jTF_Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTF_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTF_Classificacao, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTF_Aluguel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(4, 4, 4)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel14)
                                        .addComponent(jLabel16))))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTF_CodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ComboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTF_DataLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(4, 4, 4)
                                    .addComponent(jLabel19))
                                .addComponent(jTF_DataDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(lbCapa, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Cadastrar", jPanel1);

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("Pesquisar por Codigo");

        jTf_a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTf_aActionPerformed(evt);
            }
        });

        jToggleButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/lupa1.png"))); // NOI18N
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Pesquisar por Codigo DO DVD");

        jTF_b.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTF_bActionPerformed(evt);
            }
        });

        jToggleButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/lupa1.png"))); // NOI18N
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Pesquisar por Codigo do Cliente");

        JTf_c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTf_cActionPerformed(evt);
            }
        });

        jToggleButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/lupa1.png"))); // NOI18N
        jToggleButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton4ActionPerformed(evt);
            }
        });

        jToggleButton5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jToggleButton5.setText("Todos");
        jToggleButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton5ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "DVD", "Cliente", "Horario alugado", "Data em que foi alugado", "Devolução"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(388, 388, 388)
                                .addComponent(jLabel21)
                                .addGap(18, 18, 18)
                                .addComponent(jTF_b, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel20)
                                .addGap(18, 18, 18)
                                .addComponent(jTf_a, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jToggleButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel22)
                                .addGap(18, 18, 18)
                                .addComponent(JTf_c, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jToggleButton3)
                                .addContainerGap(220, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jToggleButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jToggleButton5)
                                .addGap(49, 49, 49))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel22)
                                .addComponent(JTf_c, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jToggleButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jToggleButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel21)
                                .addComponent(jTF_b, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel20)
                                .addComponent(jTf_a, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jToggleButton5, javax.swing.GroupLayout.Alignment.LEADING))))
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Consultar", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 937, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTF_DataLocacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTF_DataLocacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTF_DataLocacaoActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        String dvd = jTF_CodigoDVD.getText();
        String cliente = jTF_CodCliente.getText();
        String horario = jTF_Horas.getText();
        String aluguel = jTF_DataLocacao.getText();
        
        if (dvd.equals("") || cliente.equals("") || jTF_DataDevolucao.getDate() == null) {
            
            JOptionPane.showMessageDialog(null, "nenhum campo pode estar vazio", "Video Locadora", JOptionPane.WARNING_MESSAGE);
            
        } else {
            
            String devolucao = new SimpleDateFormat("dd/MM/yyyy").format(jTF_DataDevolucao.getDate());
            
            Connection con = Conexao.AbrirConexao();
            AluguelDAO sql = new AluguelDAO(con);
            
            int coddvd = Integer.parseInt(dvd);
            int codcli = Integer.parseInt(cliente);

            Aluguel a = new Aluguel();
            
            a.setCoddvd(coddvd);
            a.setCodcliente(codcli);
            a.setHorario(horario); 
            a.setData_aluguel(aluguel);
            a.setData_devolucao(devolucao);
             
            sql.Inserir_Aluguel(a);

            String situacao = "Emprestado";
            sql.Atualizar_Situacao(coddvd, situacao);
            Conexao.FecharConexao(con);
            
            JOptionPane.showMessageDialog(null, "Cadastro Realizado com sucesso", "Video Locadora", JOptionPane.INFORMATION_MESSAGE);
            dispose();
            
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
        
        String pesquisa = jTF_CodDVD.getText();
        Connection con = Conexao.AbrirConexao();
        
        if (pesquisa.equals("")) {
            
            JOptionPane.showMessageDialog(null, "Digite o codigo do DVD", "Video Locadora", JOptionPane.WARNING_MESSAGE);
            
        } else {
            
            DVDDAO sql = new DVDDAO(con);                    
            int cod = Integer.parseInt(pesquisa);
            
            if (sql.Teste_DVD(cod) == false) {

                JOptionPane.showMessageDialog(null, "Codigo não encontrado", "Video Locadora", JOptionPane.ERROR_MESSAGE);
                
                jTF_CodDVD.setText("");
                jTF_Titulo.setText("");
                jTF_Aluguel.setText("");
                jTF_Categoria.setText("");
                jTF_Classificacao.setText("");
                lbCapa.setIcon(new ImageIcon(""));
                jTF_CodigoDVD.setText("");

            } else if (sql.Testar_Situacao(cod) == false) {
                
                JOptionPane.showMessageDialog(null, "O DVD de codigo ('"+ cod +"') esta emprestado", "Video Locadora", JOptionPane.ERROR_MESSAGE);
                
                jTF_CodDVD.setText("");
                jTF_Titulo.setText("");
                jTF_Aluguel.setText("");
                jTF_Categoria.setText("");
                jTF_Classificacao.setText("");
                lbCapa.setIcon(new ImageIcon(""));
                jTF_CodigoDVD.setText("");
                
            } else {
                
                InserirDados(cod);
                jTF_CodigoDVD.setText(pesquisa);
                jTF_CodDVD.setText("");
                
            }
            
            AtualizaDate();
            
        }
        
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void ComboClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboClienteActionPerformed
        // TODO add your handling code here:
        
        SelecionarCombo();
        
    }//GEN-LAST:event_ComboClienteActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        // TODO add your handling code here:
        
        PesquisarCod();
        
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jTf_aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTf_aActionPerformed
        // TODO add your handling code here:
        
        PesquisarCod();
        
    }//GEN-LAST:event_jTf_aActionPerformed

    private void jTF_bActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTF_bActionPerformed
        // TODO add your handling code here:
        
        PesquisarCodDVD();
        
    }//GEN-LAST:event_jTF_bActionPerformed

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
        // TODO add your handling code here:
        
        PesquisarCodDVD();
        
    }//GEN-LAST:event_jToggleButton3ActionPerformed

    private void jToggleButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton4ActionPerformed
        // TODO add your handling code here:
        
        PesquisarCodCliente();
        
    }//GEN-LAST:event_jToggleButton4ActionPerformed

    private void JTf_cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTf_cActionPerformed
        // TODO add your handling code here:
        
        PesquisarCodCliente();
        
    }//GEN-LAST:event_JTf_cActionPerformed

    private void jToggleButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton5ActionPerformed
        // TODO add your handling code here:
        
        AtualizaTable();
        
    }//GEN-LAST:event_jToggleButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Locacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Locacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Locacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Locacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Locacao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Categoria;
    private javax.swing.JComboBox<String> ComboCliente;
    private javax.swing.JTextField JTf_c;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTF_Aluguel;
    private javax.swing.JTextField jTF_Categoria;
    private javax.swing.JTextField jTF_Classificacao;
    private javax.swing.JTextField jTF_CodCliente;
    private javax.swing.JTextField jTF_CodDVD;
    private javax.swing.JTextField jTF_CodigoDVD;
    private com.toedter.calendar.JDateChooser jTF_DataDevolucao;
    private javax.swing.JFormattedTextField jTF_DataLocacao;
    private javax.swing.JFormattedTextField jTF_Horas;
    private javax.swing.JTextField jTF_Titulo;
    private javax.swing.JTextField jTF_b;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTf_a;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton4;
    private javax.swing.JToggleButton jToggleButton5;
    private javax.swing.JLabel lbCapa;
    // End of variables declaration//GEN-END:variables
}
