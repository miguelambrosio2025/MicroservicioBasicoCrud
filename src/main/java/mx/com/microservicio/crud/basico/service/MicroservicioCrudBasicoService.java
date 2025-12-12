package mx.com.microservicio.crud.basico.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import mx.com.microservicio.crud.basico.dto.MicroservicioCrudBasicoRequestDTO;
import mx.com.microservicio.crud.basico.dto.MicroservicioCrudBasicoResponseDTO;

@Service
public class MicroservicioCrudBasicoService {
	
	
	private Map<Long, MicroservicioCrudBasicoResponseDTO> clientes = new HashMap<Long, MicroservicioCrudBasicoResponseDTO>();
	private Long secuencia = 0L;
	
	public MicroservicioCrudBasicoResponseDTO registrarCliente(MicroservicioCrudBasicoRequestDTO microservicioCrudBasicoRequestDTO) {
		MicroservicioCrudBasicoResponseDTO microservicioCrudBasicoResponseDTO = new MicroservicioCrudBasicoResponseDTO();
		
		secuencia= secuencia+1;
		
		microservicioCrudBasicoResponseDTO.setNombre(microservicioCrudBasicoRequestDTO.getNombre());
		microservicioCrudBasicoResponseDTO.setApellidoPaterno(microservicioCrudBasicoRequestDTO.getApellidoPaterno());
		microservicioCrudBasicoResponseDTO.setApellidoMaterno(microservicioCrudBasicoRequestDTO.getApellidoMaterno());
		microservicioCrudBasicoResponseDTO.setCorreo(microservicioCrudBasicoRequestDTO.getCorreo());
		microservicioCrudBasicoResponseDTO.setEdad(microservicioCrudBasicoRequestDTO.getEdad());
		microservicioCrudBasicoResponseDTO.setId(secuencia);
		clientes.put(secuencia, microservicioCrudBasicoResponseDTO);  
		
				
		return microservicioCrudBasicoResponseDTO;
		
	}
	
	public MicroservicioCrudBasicoResponseDTO consultarCliente(Long id){
		MicroservicioCrudBasicoResponseDTO microservicioCrudBasicoResponseDTO = new MicroservicioCrudBasicoResponseDTO();
		
		if (!clientes.isEmpty()) {
			
			microservicioCrudBasicoResponseDTO = clientes.get(id);
			
		}else {
			microservicioCrudBasicoResponseDTO= null;
		}
		
		return microservicioCrudBasicoResponseDTO;
	}
	
	
	public List<MicroservicioCrudBasicoResponseDTO> consultarClientes(){
	 List<MicroservicioCrudBasicoResponseDTO> microservicioCrudBasicoResponseDTOLista = null;
		
		if (!clientes.isEmpty()) {
			
			microservicioCrudBasicoResponseDTOLista = new ArrayList<MicroservicioCrudBasicoResponseDTO>(clientes.values());
			
		}
		
		return microservicioCrudBasicoResponseDTOLista;
	}

	
	public boolean eliminarCliente(Long id) {
		boolean eliminado= false;
		MicroservicioCrudBasicoResponseDTO microservicioCrudBasicoResponseDTO = new MicroservicioCrudBasicoResponseDTO();
		
		if (!clientes.isEmpty()) {
			
			microservicioCrudBasicoResponseDTO = clientes.get(id);
			if (microservicioCrudBasicoResponseDTO!=null) {
				clientes.remove(id);
				eliminado=true;
			}
			
		}
		return eliminado;
		
	}
	public MicroservicioCrudBasicoResponseDTO actualizarCliente(Long id,MicroservicioCrudBasicoRequestDTO microservicioCrudBasicoRequestDTO) {
		MicroservicioCrudBasicoResponseDTO microservicioCrudBasicoResponseDTO = null;
		
		if (!clientes.isEmpty()) {
			
			microservicioCrudBasicoResponseDTO = clientes.get(id);
			
			if (microservicioCrudBasicoResponseDTO!=null) {
				microservicioCrudBasicoResponseDTO.setNombre(microservicioCrudBasicoRequestDTO.getNombre());
				microservicioCrudBasicoResponseDTO.setApellidoPaterno(microservicioCrudBasicoRequestDTO.getApellidoPaterno());
				microservicioCrudBasicoResponseDTO.setApellidoMaterno(microservicioCrudBasicoRequestDTO.getApellidoMaterno());
				microservicioCrudBasicoResponseDTO.setCorreo(microservicioCrudBasicoRequestDTO.getCorreo());
				microservicioCrudBasicoResponseDTO.setEdad(microservicioCrudBasicoRequestDTO.getEdad());
				 clientes.put(id,microservicioCrudBasicoResponseDTO);
			}
			
			
		}
		
		
		
				
		return microservicioCrudBasicoResponseDTO;
		
	}
	
}
