package sistema;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class Produto {
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
}

class ItemPedido {
    private Produto produto;
    private int quantidade;

    public ItemPedido(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double calcularTotal() {
        return quantidade * produto.getPreco();
    }
}

class Pedido {
    private int numero;
    private ArrayList<ItemPedido> itens;

    public Pedido(int numero) {
        this.numero = numero;
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(ItemPedido item) {
        itens.add(item);
    }

    public boolean removerItem() {
        if (itens.size() > 1) {
            itens.remove(itens.size() - 1);
            return true;
        }
        return false;
    }

    public double calcularTotalPedido() {
        double total = 0;
        for (ItemPedido item : itens) {
            total += item.calcularTotal();
        }
        return total;
    }

    public void reservarMesa() {
        
    }
}

public class TelaPrincipal extends JFrame {
    private Pedido pedidoAtual;
    private ArrayList<Produto> produtos;

    public TelaPrincipal() {
        super("Sistema de Pedidos em Restaurante");
        setSize(858, 545);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

        produtos = new ArrayList<>();
        produtos.add(new Produto("Pizza", 25.0));
        produtos.add(new Produto("Hambúrguer", 15.0));
        produtos.add(new Produto("Salada", 10.0));
        

        JPanel panel = new JPanel();

        JButton adicionarProdutoBtn = new JButton("Adicionar Produto");
        adicionarProdutoBtn.setForeground(new Color(64, 128, 128));
        adicionarProdutoBtn.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
        adicionarProdutoBtn.setBounds(274, 438, 301, 37);
        JButton fazerPedidoBtn = new JButton("Fazer Pedido");
        fazerPedidoBtn.setForeground(new Color(64, 0, 0));
        fazerPedidoBtn.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
        fazerPedidoBtn.setBounds(274, 90, 301, 37);
        JButton calcularTotalBtn = new JButton("Calcular Total do Pedido");
        calcularTotalBtn.setForeground(new Color(255, 128, 64));
        calcularTotalBtn.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
        calcularTotalBtn.setBounds(274, 232, 301, 37);
        JButton adicionarItemBtn = new JButton("Adicionar Item");
        adicionarItemBtn.setForeground(new Color(0, 128, 128));
        adicionarItemBtn.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
        adicionarItemBtn.setBounds(274, 138, 301, 37);
        JButton removerItemBtn = new JButton("Remover Item");
        removerItemBtn.setForeground(new Color(128, 128, 0));
        removerItemBtn.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
        removerItemBtn.setBounds(274, 185, 301, 37);
        JButton reservarMesaBtn = new JButton("Reservar Mesa");
        reservarMesaBtn.setForeground(new Color(64, 0, 128));
        reservarMesaBtn.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
        reservarMesaBtn.setBackground(new Color(255, 255, 255));
        reservarMesaBtn.setBounds(274, 279, 301, 37);
        panel.setLayout(null);
        
        JLabel lblNewLabel_5_2_1 = new JLabel("");
        lblNewLabel_5_2_1.setIcon(new ImageIcon("C:\\Users\\chrih\\Downloads\\pngwing.com (22)_resized.png"));
        lblNewLabel_5_2_1.setBounds(513, 438, 39, 37);
        panel.add(lblNewLabel_5_2_1);
        
        JLabel lblNewLabel_5_2 = new JLabel("");
        lblNewLabel_5_2.setIcon(new ImageIcon("C:\\Users\\chrih\\Downloads\\pngwing.com (22)_resized.png"));
        lblNewLabel_5_2.setBounds(305, 438, 39, 37);
        panel.add(lblNewLabel_5_2);
        
        JLabel lblNewLabel_5_1 = new JLabel("");
        lblNewLabel_5_1.setIcon(new ImageIcon("C:\\Users\\chrih\\Downloads\\pngwing.com (21)_resized.png"));
        lblNewLabel_5_1.setBounds(513, 279, 39, 37);
        panel.add(lblNewLabel_5_1);
        
        JLabel lblNewLabel_5 = new JLabel("");
        lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\chrih\\Downloads\\pngwing.com (21)_resized.png"));
        lblNewLabel_5.setBounds(305, 279, 39, 37);
        panel.add(lblNewLabel_5);
        
        JLabel lblNewLabel_4_1 = new JLabel("");
        lblNewLabel_4_1.setIcon(new ImageIcon("C:\\Users\\chrih\\Downloads\\pngwing.com (20)_resized (1).png"));
        lblNewLabel_4_1.setBounds(511, 90, 39, 37);
        panel.add(lblNewLabel_4_1);
        
        JLabel lblNewLabel_4 = new JLabel("");
        lblNewLabel_4.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/sistema/imagens/pngwing.com (20)_resized (1).png")));
        lblNewLabel_4.setBounds(305, 90, 39, 37);
        panel.add(lblNewLabel_4);
        
        JLabel lblNewLabel_3_1 = new JLabel("");
        lblNewLabel_3_1.setIcon(new ImageIcon("C:\\Users\\chrih\\Downloads\\pngwing.com (19)_resized.png"));
        lblNewLabel_3_1.setBounds(511, 185, 30, 37);
        panel.add(lblNewLabel_3_1);
        
        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\chrih\\Downloads\\pngwing.com (19)_resized.png"));
        lblNewLabel_3.setBounds(305, 185, 30, 37);
        panel.add(lblNewLabel_3);
        
        JLabel lblNewLabel_2_1 = new JLabel("");
        lblNewLabel_2_1.setIcon(new ImageIcon("C:\\Users\\chrih\\Downloads\\pngwing.com (18)_resized.png"));
        lblNewLabel_2_1.setBounds(511, 232, 30, 37);
        panel.add(lblNewLabel_2_1);
        
        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\chrih\\Downloads\\pngwing.com (18)_resized.png"));
        lblNewLabel_2.setBounds(305, 232, 30, 37);
        panel.add(lblNewLabel_2);
        
        JLabel lblNewLabel_1_1 = new JLabel("");
        lblNewLabel_1_1.setIcon(new ImageIcon("C:\\Users\\chrih\\Downloads\\pngwing.com__17__compressed_resized-removebg-preview_resized (1)_resized.png"));
        lblNewLabel_1_1.setBounds(513, 144, 39, 31);
        panel.add(lblNewLabel_1_1);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\chrih\\Downloads\\pngwing.com__17__compressed_resized-removebg-preview_resized (1)_resized.png"));
        lblNewLabel_1.setBounds(305, 144, 39, 31);
        panel.add(lblNewLabel_1);

        panel.add(adicionarProdutoBtn);
        panel.add(fazerPedidoBtn);
        panel.add(calcularTotalBtn);
        panel.add(adicionarItemBtn);
        panel.add(removerItemBtn);
        panel.add(reservarMesaBtn);

        getContentPane().add(panel, BorderLayout.CENTER);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\chrih\\Downloads\\restaurante-de-cafe-cafeteria-borrao-com-fundo-bokeh_resized (1)_resized_resized.jpg"));
        lblNewLabel.setBounds(10, 16, 822, 468);
        panel.add(lblNewLabel);

        adicionarProdutoBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                adicionarProduto();
            }
        });

        fazerPedidoBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fazerPedido();
            }
        });

        calcularTotalBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularTotalPedido();
            }
        });

        adicionarItemBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                adicionarItem();
            }
        });

        removerItemBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removerItem();
            }
        });

        reservarMesaBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                reservarMesa();
            }
        });

        setVisible(true);
    }

    private void adicionarProduto() {
        String nome = JOptionPane.showInputDialog(this, "Digite o nome do produto:");
        double preco = Double.parseDouble(JOptionPane.showInputDialog(this, "Digite o preço do produto:"));
        produtos.add(new Produto(nome, preco));
        JOptionPane.showMessageDialog(this, "Produto adicionado com sucesso!");
    }

    private void fazerPedido() {
        pedidoAtual = new Pedido(1);
        JOptionPane.showMessageDialog(this, "Pedido iniciado. Adicione itens ao pedido.");
    }

    private void calcularTotalPedido() {
        if (pedidoAtual != null) {
            double total = pedidoAtual.calcularTotalPedido();
            JOptionPane.showMessageDialog(this, "O total do pedido é: R$ " + total);
        } else {
            JOptionPane.showMessageDialog(this, "Nenhum pedido foi iniciado ainda.");
        }
    }

    private void adicionarItem() {
        if (pedidoAtual != null) {
            String[] opcoes = new String[produtos.size()];
            for (int i = 0; i < produtos.size(); i++) {
                opcoes[i] = produtos.get(i).getNome();
            }
            String escolha = (String) JOptionPane.showInputDialog(this, "Escolha um produto:", "Adicionar Item",
                    JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);

            if (escolha != null) {
                Produto produtoEscolhido = null;
                for (Produto produto : produtos) {
                    if (produto.getNome().equals(escolha)) {
                        produtoEscolhido = produto;
                        break;
                    }
                }
                if (produtoEscolhido != null) {
                    int quantidade = Integer.parseInt(JOptionPane.showInputDialog(this, "Digite a quantidade do produto:"));
                    ItemPedido item = new ItemPedido(produtoEscolhido, quantidade);
                    pedidoAtual.adicionarItem(item);
                    JOptionPane.showMessageDialog(this, "Item adicionado ao pedido.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Nenhum pedido foi iniciado ainda.");
        }
    }

    private void removerItem() {
        if (pedidoAtual != null) {
            boolean removido = pedidoAtual.removerItem();
            if (removido) {
                JOptionPane.showMessageDialog(this, "Item removido do pedido.");
            } else {
                JOptionPane.showMessageDialog(this, "Não é possível remover mais itens. O pedido deve conter pelo menos um item.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Nenhum pedido foi iniciado ainda.");
        }
    }

    private void reservarMesa() {
        if (pedidoAtual != null) {
            
            JOptionPane.showMessageDialog(this, "Mesa reservada para o pedido.");
        } else {
            JOptionPane.showMessageDialog(this, "Nenhum pedido foi iniciado ainda.");
        }
    }

    public static void main(String[] args) {
        new TelaPrincipal();
    }
}