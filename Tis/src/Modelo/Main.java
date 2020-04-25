package Modelo;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import DAO.UsuarioDAO;

public class Main {

    public static void main(String[] args) throws IOException {

       try {
           UsuarioDAO usuarioDAO =  null;
           usuarioDAO = new UsuarioDAO("usuarios.bin"); 
           var usuario = new Usuario();
           Scanner entrada = new Scanner(System.in);

           System.out.println("Digite o seu nome: ");
           usuario.setNome(entrada.next());
           System.out.println("Digite o cpf: ");
           usuario.setCpf(entrada.next());
           System.out.println("Digite o seu email: ");
           usuario.setEmail(entrada.next());
           System.out.println("Digite o seu telefone: ");
           usuario.setTelefone(entrada.next());
           System.out.println("Digite seu id: ");
           usuario.setId(entrada.nextInt());

           usuarioDAO.add(usuario);

           List<Usuario> listaDeUsuarios;

           listaDeUsuarios = usuarioDAO.getAll();

           for (Usuario user : listaDeUsuarios) {
               System.out.println(user.getId());
               System.out.println(user.getNome());
               System.out.println(user.getEmail());
               System.out.println(user.getCpf());
           }
           entrada.close();

       } catch (Exception e) {
           System.out.println("Erro Ao Conectar com Arquivo de Auditorias");
       }
       
    }
}
