package com.tvoseguridadelectronica.oss.restcontroller;

import com.tvoseguridadelectronica.oss.domain.Report;
import com.tvoseguridadelectronica.oss.domain.WorkOrder;
import com.tvoseguridadelectronica.oss.domain.WorkOrderDevice;
import com.tvoseguridadelectronica.oss.domain.WorkOrderMaterial;
import com.tvoseguridadelectronica.oss.domain.WorkOrderTool;
import com.tvoseguridadelectronica.oss.jparepository.WorkOrderDeviceJpaRepository;
import com.tvoseguridadelectronica.oss.jparepository.WorkOrderJpaRepository;
import com.tvoseguridadelectronica.oss.jparepository.WorkOrderMaterialJpaRepository;
import com.tvoseguridadelectronica.oss.jparepository.WorkOrderToolJpaRepository;
import com.tvoseguridadelectronica.oss.repository.WorkOrderDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({ "/api/workorder" })
public class WorkOrderRestController {

	@Autowired
	private WorkOrderJpaRepository workOrderJpaRepository;
	@Autowired
	private WorkOrderDao workOrderDao;
	@Autowired
	private WorkOrderDeviceJpaRepository workOrderDeviceJpaRepository;
	@Autowired
	private WorkOrderMaterialJpaRepository workOrderMaterialJpaRepository;
	@Autowired
	private WorkOrderToolJpaRepository workOrderToolJpaRepository;

	@GetMapping("/")
	public ResponseEntity<List<WorkOrder>> listAllWorkOrder() {
		List<WorkOrder> workOrders = workOrderJpaRepository.findAll();

		return new ResponseEntity<List<WorkOrder>>(workOrders, HttpStatus.OK);
	}

	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<WorkOrder> createWorkOrder(@RequestBody final WorkOrder workOrder) {
		WorkOrder workOrderSaved = workOrderJpaRepository.save(workOrder);
		int idSaved = workOrderSaved.getId();

		if (workOrderSaved != null) {
			List<WorkOrderMaterial> listWorkOrderMaterials = workOrder.getListWorkOrderMaterials();
			List<WorkOrderDevice> listWorkOrderDevices = workOrder.getListWorkOrderDevices();
			List<WorkOrderTool> listWorkOrderTools = workOrder.getListWorkOrderTools();

			if (listWorkOrderMaterials != null && listWorkOrderMaterials.size() > 0) {
				for (Iterator iterator = listWorkOrderMaterials.iterator(); iterator.hasNext();) {
					WorkOrderMaterial workOrderMaterial = (WorkOrderMaterial) iterator.next();
					workOrderMaterial.getId().getWorkOrder().setId(idSaved);
					workOrderMaterialJpaRepository.save(workOrderMaterial);
				}
			}

			if (listWorkOrderDevices != null && listWorkOrderDevices.size() > 0) {
				for (Iterator iterator = listWorkOrderDevices.iterator(); iterator.hasNext();) {
					WorkOrderDevice workOrderDevice = (WorkOrderDevice) iterator.next();
					workOrderDevice.getId().getWorkOrder().setId(idSaved);
					workOrderDeviceJpaRepository.save(workOrderDevice);
				}
			}

			if (listWorkOrderTools != null && listWorkOrderTools.size() > 0) {
				for (Iterator iterator = listWorkOrderTools.iterator(); iterator.hasNext();) {
					WorkOrderTool workOrderTool = (WorkOrderTool) iterator.next();
					workOrderTool.getId().getWorkOrder().setId(idSaved);
					workOrderToolJpaRepository.save(workOrderTool);
				}
			}

		}

		return new ResponseEntity<WorkOrder>(workOrder, HttpStatus.NO_CONTENT);
	}

	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<WorkOrder> editWorkOrder(@PathVariable("id") final Integer id,
			@RequestBody final WorkOrder workOrder) {

		int idUpdated = workOrder.getId();
		
		
		if(workOrder!=null) {
			this.workOrderDao.removeWorkOrderDevicesById(idUpdated);
			this.workOrderDao.removeWorkOrderToolsById(idUpdated);
			this.workOrderDao.removeWorkOrderMaterialsById(idUpdated);	
			
			List<WorkOrderMaterial> listWorkOrderMaterials = workOrder.getListWorkOrderMaterials();
			List<WorkOrderDevice> listWorkOrderDevices = workOrder.getListWorkOrderDevices();
			List<WorkOrderTool> listWorkOrderTools = workOrder.getListWorkOrderTools();

			if (listWorkOrderMaterials != null && listWorkOrderMaterials.size() > 0) {
				for (Iterator iterator = listWorkOrderMaterials.iterator(); iterator.hasNext();) {
					WorkOrderMaterial workOrderMaterial = (WorkOrderMaterial) iterator.next();
					workOrderMaterial.getId().getWorkOrder().setId(idUpdated);
					workOrderMaterialJpaRepository.save(workOrderMaterial);
				}
			}

			if (listWorkOrderDevices != null && listWorkOrderDevices.size() > 0) {
				for (Iterator iterator = listWorkOrderDevices.iterator(); iterator.hasNext();) {
					WorkOrderDevice workOrderDevice = (WorkOrderDevice) iterator.next();
					workOrderDevice.getId().getWorkOrder().setId(idUpdated);
					workOrderDeviceJpaRepository.save(workOrderDevice);
				}
			}

			if (listWorkOrderTools != null && listWorkOrderTools.size() > 0) {
				for (Iterator iterator = listWorkOrderTools.iterator(); iterator.hasNext();) {
					WorkOrderTool workOrderTool = (WorkOrderTool) iterator.next();
					workOrderTool.getId().getWorkOrder().setId(idUpdated);
					workOrderToolJpaRepository.save(workOrderTool);
				}
			}
			
			
		}
		workOrder.setListWorkOrderDevices(new ArrayList<WorkOrderDevice>());
		workOrder.setListWorkOrderMaterials(new ArrayList<WorkOrderMaterial>());
		workOrder.setListWorkOrderTools(new ArrayList<WorkOrderTool>());
		
		WorkOrder workOrderUpdated = workOrderJpaRepository.saveAndFlush(workOrder);

		return new ResponseEntity<WorkOrder>(workOrder, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<WorkOrder> findWorkOrderById(@PathVariable("id") final int id) {

		WorkOrder workOrder = workOrderJpaRepository.findById(id).get();
		return new ResponseEntity<WorkOrder>(workOrder, HttpStatus.OK);

	}

	@GetMapping("/findworkorderbystartdate/{date}")
	public ResponseEntity<List<WorkOrder>> findWorkOrderByStartDate(@PathVariable("date") final String date) {

		List<WorkOrder> workOrder = workOrderDao.findWorkOrdersByStartDateLike(date);
		return new ResponseEntity<List<WorkOrder>>(workOrder, HttpStatus.OK);

	}

	@GetMapping("/findworkorderbyweekwithstartdateandenddate/{dateStart}/{dateEnd}")
	public ResponseEntity<List<WorkOrder>> findWorkOrderByWeek(@PathVariable("dateStart") final String dateStart,
			@PathVariable("dateEnd") final String dateEnd) {

		List<WorkOrder> workOrder = workOrderDao.findWorkOrdersByWeekWithStartDateAndEndDateLike(dateStart, dateEnd);
		return new ResponseEntity<List<WorkOrder>>(workOrder, HttpStatus.OK);

	}

	@GetMapping("/findworkorderbymonthandyear/{date}")
	public ResponseEntity<List<WorkOrder>> findWorkOrderByMonth(@PathVariable("date") final String date) {

		List<WorkOrder> workOrder = workOrderDao.findWorkOrdersByMonthAndYear(date);
		return new ResponseEntity<List<WorkOrder>>(workOrder, HttpStatus.OK);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<WorkOrder> deleteWorkOrder(@PathVariable("id") final int id) {
		workOrderJpaRepository.deleteById(id);
		return new ResponseEntity<WorkOrder>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/reportbytypedate/{id}/{startDate}/{endDate}")
	public ResponseEntity<List<Report>> reportByTypeAndDate(@PathVariable("id") final int id,@PathVariable("startDate") final String startDate,
			@PathVariable("endDate") final String endDate) {

		List<Report> reportList = workOrderDao.reportWorkOrderByTypeAndDate(id, startDate, endDate);
		return new ResponseEntity<List<Report>>(reportList, HttpStatus.OK);

	}
	
	@GetMapping("/reportbyclientdate/{id}/{startDate}/{endDate}")
	public ResponseEntity<List<Report>> reportByClientAndDate(@PathVariable("id") final int id,@PathVariable("startDate") final String startDate,
			@PathVariable("endDate") final String endDate) {

		List<Report> reportList = workOrderDao.reportWorkOrderByClientAndDate(id, startDate, endDate);
		return new ResponseEntity<List<Report>>(reportList, HttpStatus.OK);

	}
}
