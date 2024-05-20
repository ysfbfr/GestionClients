package webAppSpringMvc.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Client {
	
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id ;
	@NotEmpty
	@Size (min = 4 , max=15)
	private String nom;
	
	@NotEmpty
	@Size (min = 4 , max=15)
	private String prenom;
	
	@NotEmpty
	private String adress;
}
