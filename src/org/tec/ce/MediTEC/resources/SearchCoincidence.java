package org.tec.ce.MediTEC.resources;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.tec.ce.DataStructures.LinkedList.LinkedList;
import org.tec.ce.DataStructures.SplayTree.SplayNode;
import org.tec.ce.DataStructures.SplayTree.SplayTree;
import org.tec.ce.MediTEC.FileXMLManager;
import org.tec.ce.MediTEC.dto.DoctorDTO;

@Path("/search-coincidence")
public class SearchCoincidence {
	private SplayTree<DoctorDTO> doctorsTree;
	
	public SearchCoincidence(){
		 //Se intenta obtener el arbol splay de los doctores
		 try {
			if(FileXMLManager.checkExistence("doctorsTree.xml") == true){
				 this.doctorsTree = (SplayTree) FileXMLManager.getContent("doctorsTree.xml");
			 } else{
				 this.doctorsTree = new SplayTree();
				 FileXMLManager.writeContent(this.doctorsTree, "doctorsTree.xml");
			 }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	
	/**
	 * Metodo para obtener todos los doctores que coincidan con el criterio de busqueda
	 * @param searchID ID o extracto del ID que se esta buscando
	 * @return LinkedList con los doctores que coincidieron con el criterio de busqueda
	 */
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
    public Response searchCoincidence(@PathParam("id") int searchID){
        LinkedList<DoctorDTO> doctorsList = new LinkedList<DoctorDTO>();
        searchCoincidence(doctorsTree.getRoot(), doctorsList, String.valueOf(searchID));
        return Response.ok().entity(doctorsList).build();
    }

	/**
	 * Metodo que recorre el arbol de doctores en busca de los doctores que coinciden con el criterio de busqueda
	 * @param node Nodo actual en el recorrido
	 * @param doctorsList Lista en la que ir guardando las coincidencias
	 * @param searchID Criterio de busqueda
	 */
    private void searchCoincidence(SplayNode<DoctorDTO> node, LinkedList<DoctorDTO> doctorsList, String searchID){
        if(node != null){
        	searchCoincidence(node.getLeft(), doctorsList, searchID);

            String doctorID = String.valueOf(node.getData().getId());
            String[] id = searchID.split("\\s+");
            for(String idElement : id){
                if(doctorID.contains(idElement)){
                	doctorsList.insertAtEnd(node.getData());
                }
            }

            searchCoincidence(node.getRight(), doctorsList, searchID);
        }
    }

}
