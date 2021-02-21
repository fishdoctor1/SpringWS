package th.co.por.dao.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE20")
public class Emdd implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	public interface COLUMN {
		public static final String FIRST_NAME = "firstName";
		public static final String LAST_NAME = "lastName";
		public static final String TITLE_NAME = "titleName";
		
	}  
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TD_SEQ_SO_VOUCHER_MOVEMENT")
//	@Column(name = "VOUCHER_MOV_ID")
//	@SequenceGenerator(name = "TD_SEQ_SO_VOUCHER_MOVEMENT", sequenceName = "TD_SEQ_SO_VOUCHER_MOVEMENT", allocationSize = 1)
//	private Long voucherMovId;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "TITLE_NAME")
	private String titleName;
//	@Embedded
//	@AttributeOverrides({
//		@AttributeOverride(name = "createdBy", column = @Column(name = "CREATED_BY", nullable = false, length = 10)),
//		@AttributeOverride(name = "created", column = @Column(name = "CREATED_DTM", nullable = false)),
//		@AttributeOverride(name = "lastUpdBy", column = @Column(name = "LAST_UPD_BY", nullable = false, length = 10)),
//		@AttributeOverride(name = "lastUpd", column = @Column(name = "LAST_UPD_DTM", nullable = false)) })
//	private MasterValue createValue;	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	
	
}

