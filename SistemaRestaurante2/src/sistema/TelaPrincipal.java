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
        setSize(725, 545);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

        produtos = new ArrayList<>();
        produtos.add(new Produto("Pizza", 25.0));
        produtos.add(new Produto("Hambúrguer", 15.0));
        produtos.add(new Produto("Salada", 10.0));
        

        JPanel panel = new JPanel();

        JButton adicionarProdutoBtn = new JButton("Adicionar Produto");
        adicionarProdutoBtn.setBounds(112, 23, 384, 37);
        JButton fazerPedidoBtn = new JButton("Fazer Pedido");
        fazerPedidoBtn.setBounds(112, 85, 384, 37);
        JButton calcularTotalBtn = new JButton("Calcular Total do Pedido");
        calcularTotalBtn.setBounds(112, 158, 384, 37);
        JButton adicionarItemBtn = new JButton("Adicionar Item");
        adicionarItemBtn.setBounds(112, 246, 384, 37);
        JButton removerItemBtn = new JButton("Remover Item");
        removerItemBtn.setBounds(112, 323, 384, 37);
        JButton reservarMesaBtn = new JButton("Reservar Mesa");
        reservarMesaBtn.setBounds(112, 408, 384, 37);
        panel.setLayout(null);

        panel.add(adicionarProdutoBtn);
        panel.add(fazerPedidoBtn);
        panel.add(calcularTotalBtn);
        panel.add(adicionarItemBtn);
        panel.add(removerItemBtn);
        panel.add(reservarMesaBtn);

        getContentPane().add(panel, BorderLayout.CENTER);

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
