package app.cos.rest.model;
 
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity 
@Table
public class CowBcs implements Comparable<CowBcs> {
	
	@Id
	@Min(value = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "cow_id", referencedColumnName = "id" )
	private Cow cow;

	@Column(name = "date", nullable = false)
	private Date date;
	
	@Min(value=1)
	@Max(value=9)
	@Column(name = "cc", nullable = false)
	private int cc;

    @Override
    public int compareTo(CowBcs cowBcs) {
        return this.date.compareTo(cowBcs.getDate());
    }
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((cow == null) ? 0 : cow.hashCode());		
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CowBcs other = (CowBcs) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
    
	//-------------------------------------------------------------------------------------//
	//----------------------------- Getters && Setters ------------------------------------//
	//-------------------------------------------------------------------------------------//
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Cow getCow() {
		return cow;
	}

	public void setCow(Cow cow) {
		this.cow = cow;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getCc() {
		return cc;
	}

	public void setCc(int cc) {
		this.cc = cc;
	}
	
}
