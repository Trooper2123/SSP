package edu.sinclair.ssp.model.reference;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(schema = "public")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class VeteranStatus extends AbstractReference implements Serializable {

	private static final long serialVersionUID = 6239784400216128442L;

	public VeteranStatus() {
		super();
	}

	public VeteranStatus(UUID id) {
		super(id);
	}

	public VeteranStatus(UUID id, String name) {
		super(id, name);
	}

	public VeteranStatus(UUID id, String name, String description) {
		super(id, name, description);
	}

	/**
	 * Overwrites simple properties with the parameter's properties.
	 * 
	 * @param source
	 *            Source to use for overwrites.
	 * @see overwriteWithCollections(VeteranStatus)
	 */
	public void overwrite(VeteranStatus source) {
		this.setName(source.getName());
		this.setDescription(source.getDescription());
	}
}
