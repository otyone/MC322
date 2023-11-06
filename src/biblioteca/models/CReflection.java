package biblioteca.models;

import biblioteca.models.Membros.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import biblioteca.models.ItemMulti.*;

public class CReflection<T> implements CReflectionList<T> {
	public void imprimirAtributos(MembroM membro, Item item) { //método para imprimir atributos de membro e item
		Class <?> membroClass = MembroM.class; //atribuir classe
		Class <?> itemClass = Item.class; //atribuir classe
		
		Field[] fieldsmembro = membroClass.getDeclaredFields(); //resgatar atributos
		Field[] fieldsitem = itemClass.getDeclaredFields(); //resgatar atributos
		
		List<String> atributos1 = new ArrayList<>(); //lista para atributos
		List<String> atributos2 = new ArrayList<>(); //lista para atributos
		
		for(Field field : fieldsmembro) { //preenchendo lista
			atributos1.add(field.getName());
		}
		
		for(Field field : fieldsitem) { //preenchendo lista
			atributos2.add(field.getName());
		}
		
		System.out.println("Lista de atributos para Membro:");
		
		for(int i = 0; i < atributos1.size(); i++) { //imprimindo lista
			String curr = atributos1.get(i);
			System.out.println(curr);
		}
		
		System.out.println();
		System.out.println("Lista de atributos para Item:");
		
		for(int i = 0; i < atributos2.size(); i++) {//imprimindo lista
			String curr = atributos2.get(i);
			System.out.println(curr);
		}
		
		System.out.println();
	}
	
	public void imprimirMetodos(MembroM membro, Item item) { //método para imprimir métodos de membro e item
		Class <?> membroClass = MembroM.class; //atribuir classe
		Class <?> itemClass = Item.class; //atribuir classe
		
		Method[] methodsmembro = membroClass.getDeclaredMethods(); //resgatar métodos
		Method[] methodsitem = itemClass.getDeclaredMethods(); //resgatar métodos
		
		List<String> metodos1 = new ArrayList<>(); //lista para métodos
		List<String> metodos2 = new ArrayList<>(); //lista para métodos
		
		for(Method method : methodsmembro) { //preenchendo lista
			metodos1.add(method.getName());
		}
		
		for(Method method : methodsitem) { //preenchendo lista
			metodos2.add(method.getName());
		}
		
		System.out.println("Lista de métodos para Membro:");
		
		for(int i = 0; i < metodos1.size(); i++) { //imprimindo lista
			String curr = metodos1.get(i);
			System.out.println(curr);
		}
		
		System.out.println();
		System.out.println("Lista de métodos para Item:");
		
		for(int i = 0; i < metodos2.size(); i++) { //imprimindo lista
			String curr = metodos2.get(i);
			System.out.println(curr);
		}
		
		System.out.println();
	}

	@Override
	public void imprimirInfo(T lista) {
		try { //bloco try-catch
			Method informacoes = List.class.getMethod("size"); //resgatando método de lista
			int result = (int) informacoes.invoke(lista); //invocando método
			System.out.println("Tamanho da lista:" + result); //imprimindo resultado
			System.out.println();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}