package model.data_structures;

import java.util.HashMap;
import java.util.Map;

import model.data_structures.ListaEncadenada.Nodo;

public class TablaHashSeparateChaining<K extends Comparable<K>, V> implements TablaSimbolos <K, V>
{

	public V[] arreglo;
	public int tama�o;
	
	/**
	 * 
	 * @param El tama�o debe ser un n�mero primo que permita que haya un factor de carga 5.0, 
	 * es decir, para la lista de 300mil elementos ser�a minimo de 60mil el tama�o
	 */
	public TablaHashSeparateChaining(int pTama�o) 
	{
		tama�o = pTama�o;
		arreglo = (V[])new Object[tama�o];
		for (int i = 0; i < tama�o; i++) 
		{
			arreglo[i] = null;
		}
	}
	
	public void reHash()
	{
	}
	
	@Override
	public void put(K llave, V valor) 
	{
		NodoHash<K, V> nodoAct = (NodoHash<K, V>) arreglo[(int) llave];
		ListaEncadenada<V> listaAct = (ListaEncadenada<V>) nodoAct.getValue();
		listaAct.agregarAlPrincipio(valor);
	}
	
	@Override
	public V get(K llave) 
	{
		V rta = null;
		NodoHash<K, V> nodoAct = (NodoHash<K, V>) arreglo[(int) llave];
		ListaEncadenada<V> listaAct = (ListaEncadenada<V>) nodoAct.getValue();
		if(listaAct.darPrimerElemento()!=null)
		{
			rta = listaAct.darPrimerElemento();
		}
		return rta;
	}

	@Override
	public V remove(K llave) 
	{
		V rta = null;
		NodoHash<K, V> nodoAct = (NodoHash<K, V>) arreglo[(int) llave];
		ListaEncadenada<V> listaAct = (ListaEncadenada<V>) nodoAct.getValue();
		if(listaAct.darPrimerElemento()!=null)
		{
			rta = listaAct.darPrimerElemento();
			listaAct.borrarPorPosicion(0); 
		}
		return rta;
	}

	@Override
	public boolean contains(K llave) 
	{
		boolean rta = false;
		NodoHash<K, V> nodoAct = (NodoHash<K, V>) arreglo[(int) llave];
		ListaEncadenada<V> listaAct = (ListaEncadenada<V>) nodoAct.getValue();
		if(listaAct.darPrimerElemento()!=null)
		{
			rta = true;
		}
		return rta;
	}

	@Override
	public boolean isEmpty() 
	{
		boolean rta = true;
		for (int i = 0; i < tama�o; i++) 
		{
			NodoHash<K, V> nodoAct = (NodoHash<K, V>) arreglo[i];
			ListaEncadenada<V> listaAct = (ListaEncadenada<V>) nodoAct.getValue();
			if(listaAct.darPrimerElemento()!=null)
			{
				rta = false;
			}
		}
		return rta;
	}

	@Override
	public int size() {
		int rta = 0;
		for (int i = 0; i < tama�o; i++) 
		{
			if(arreglo[i]!=null)
			{
				rta++;
			}
		}
		return rta;
	}

	@Override
	public ListaEncadenada<K> keySet() 
	{
		ListaEncadenada<K> rta = new ListaEncadenada<K>();
		for (int i = 0; i < tama�o; i++) 
		{
			NodoHash<K, V> nodoAct = (NodoHash<K, V>) arreglo[i];
			if(nodoAct!=null) 
			{
				rta.agregarAlFinal(nodoAct.getKey());
			}	
		}
		return rta;
	}

	@Override
	public ListaEncadenada<V> valueSet() 
	{
		ListaEncadenada<V> rta = new ListaEncadenada<V>();
		for (int i = 0; i < tama�o; i++) 
		{
			NodoHash<K, V> nodoAct = (NodoHash<K, V>) arreglo[i];
			ListaEncadenada<V> listaValores = (ListaEncadenada<V>) nodoAct.getValue();
			if(listaValores.darPrimerElemento()!=null)
			{
				for (int j = 0; j < listaValores.contarDatos(); j++) 
				{
					rta.agregarAlPrincipio(listaValores.darElemento(i));
				}
			}
		}
		return rta;
	}



}
