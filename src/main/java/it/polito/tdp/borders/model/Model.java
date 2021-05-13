package it.polito.tdp.borders.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.alg.connectivity.ConnectivityInspector;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.borders.db.BordersDAO;


public class Model {
	
        BordersDAO bdao;
		
		Graph<Country, DefaultEdge> grafo;
		Map<Integer, Country> idMap = new HashMap<Integer, Country>();
		
		private ConnectivityInspector<Country, DefaultEdge> ce;
	public Model() {
		bdao = new BordersDAO();		
	}
	
	public String creaGrafo(int anno) {
		String result = "";
		grafo = new SimpleGraph<>(DefaultEdge.class);
		ce = new ConnectivityInspector<>(grafo);
		bdao.loadAllCountries(idMap);
		
		
		
			for(Border b : bdao.getBorders(anno, idMap)) {
				if(!grafo.containsVertex(b.getC1()))
					grafo.addVertex(b.getC1());
				
				if(!grafo.containsVertex(b.getC2()))
					grafo.addVertex(b.getC2());

				
                DefaultEdge e = grafo.getEdge(b.getC1(), b.getC2() );
				
                if(e == null) {
                	grafo.addEdge(b.getC1(), b.getC2());
                }
				
		        
			}
			
			result = "Numero componenti connesse: " + ce.connectedSets().size() + "\n";
			
			for(Country c : grafo.vertexSet()) {
			result += c.getStateName() + ": " + grafo.degreeOf(c) + "\n";
			}
		
		return result;
	}
		
	public Set<Country> getNodi(){
		return grafo.vertexSet();
	}


	public Set<Country> trovaRaggiungibili(Country c){
		
		Set<Country> raggiungibili = new HashSet<>();
		
		raggiungibili = ce.connectedSetOf(c);
		
		return raggiungibili;
	
	}
	}


