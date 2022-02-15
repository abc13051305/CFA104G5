package ezs.ren_appointment.model;

import java.util.List;
import java.util.Map;

public interface RenAppointmentDAO_interface {
	public void insert(RenAppointmentVO appointmentVO);
	public void update(RenAppointmentVO appointmentVO);
	public void delete(Integer aptId);
	public RenAppointmentVO findByPK(Integer aptId);
	public List<RenAppointmentVO> getAll();
//	public List<RenAppointmentVO> findByMem(Integer apt_mem_id);
	public List<RenAppointmentVO> getAll(Map<String, String[]> map);

}
