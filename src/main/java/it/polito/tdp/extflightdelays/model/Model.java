package it.polito.tdp.extflightdelays.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.extflightdelays.db.ExtFlightDelaysDAO;

public class Model {
	
	private Graph<Airport,DefaultWeightedEdge> grafo;
	
	public Graph<Airport,DefaultWeightedEdge> creaGrafo(double distanzaMinima) {
		this.grafo = new SimpleWeightedGraph<Airport,DefaultWeightedEdge>(DefaultWeightedEdge.class);
		
		ExtFlightDelaysDAO dao = new ExtFlightDelaysDAO();
		
		List<Airport> aeroporti = dao.loadAllAirports();
		Map<Integer, Airport> aeroportiIdMap = new HashMap<Integer, Airport>();
		for(Airport a : aeroporti)
			aeroportiIdMap.put(a.getId(), a);
		
		Graphs.addAllVertices(this.grafo, aeroporti);
		
		Set<CoppiaAirport> setCoppie = dao.getAverageDistances();
		
		for(CoppiaAirport ca : setCoppie) {
			if(ca.getDistanzaMedia()>distanzaMinima) {
				Graphs.addEdge(this.grafo, aeroportiIdMap.get(ca.getOriginAirportId()), aeroportiIdMap.get(ca.getDestinationAirportId()), ca.getDistanzaMedia());
			}
		}
		/*
		System.out.println("Vertici: " + this.grafo.vertexSet().size());
		System.out.println("Edges: " + this.grafo.edgeSet().size()+"\n");
		
		for(DefaultWeightedEdge e : this.grafo.edgeSet()) {
			System.out.println("Arco tra " +grafo.getEdgeSource(e).getAirportName()+"("+grafo.getEdgeSource(e).getId()+")"
					+ " e " + grafo.getEdgeTarget(e).getAirportName()+"("+grafo.getEdgeTarget(e).getId()+")"
					+" : " + grafo.getEdgeWeight(e)+"\n");
		}
		*/
		
		return this.grafo;
	}

}
