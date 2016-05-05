package cz.mendelu.seminar.swi.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author Peter Smatana
 * @author pirochta.jiri@gmail.com
 */
@Entity
public class WarehousemanEntity {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_warehouseman;
	
    @NotNull
    private Date startDate;
	
    @NotNull
    private Date endDate;
	
    public  WarehousemanEntity() {
        
    }
	
    public  WarehousemanEntity(int id_warehouseman, Date startDate, Date endDate) {
        this.id_warehouseman = id_warehouseman;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getId_warehouseman()
    {
            return id_warehouseman;
    }

    public void setId_warehouseman(int id_warehouseman)
    {
            this.id_warehouseman = id_warehouseman;
    }

    public Date getStartDate()
    {
            return startDate;
    }

    public void setStartDate(Date startDate)
    {
            this.startDate = startDate;
    }

    public Date getEndDate()
    {
            return endDate;
    }

    public void setEndDate(Date endDate)
    {
            this.endDate = endDate;
    }
	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WarehousemanEntity)) return false;

        WarehousemanEntity warehouseman = (WarehousemanEntity) o;

        if (getId_warehouseman() != warehouseman.getId_warehouseman()){
                return false;
        }
        if (getStartDate() != warehouseman.getStartDate()){
                return false;
        }
        if (getEndDate() != null ? !getEndDate().equals(warehouseman.getEndDate()) : warehouseman.getEndDate() != null){
                return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = getId_warehouseman();
        result = 31 * result + getStartDate().hashCode();
		result = 31 * result + getEndDate().hashCode();
        return result;
    }
}
