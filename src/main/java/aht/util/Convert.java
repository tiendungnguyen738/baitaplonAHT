package aht.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import aht.dto.ContractDTO;
import aht.dto.ContractEmpDTO;
import aht.dto.DepartmentDTO;
import aht.dto.EmployeeDTO;
import aht.dto.PartDTO;
import aht.dto.RoleDTO;
import aht.dto.TrainingDTO;
import aht.dto.TrainingEmpDTO;
import aht.dto.UserDTO;
import aht.dto.UserRoleDTO;
import aht.entity.AhtContract;
import aht.entity.AhtContractEmp;
import aht.entity.AhtDepartment;
import aht.entity.AhtEmployee;
import aht.entity.AhtParts;
import aht.entity.AhtRole;
import aht.entity.AhtTraining;
import aht.entity.AhtTraningEmp;
import aht.entity.AhtUser;
import aht.entity.AhtUserRole;

@Component
public class Convert {
	
	public static RoleDTO fromAhtRoleToRoleDTO(AhtRole ahtRole) {
		RoleDTO roleDTO = new RoleDTO();
		roleDTO.setId(ahtRole.getId());
		roleDTO.setRoleName(ahtRole.getRoleName());
		return roleDTO;
	}
	
	public static List<UserDTO> fromAhtUserListToUserDTOList(List<AhtUser> ahtUsers){
		List<UserDTO> dtos = new ArrayList<UserDTO>();
		for (AhtUser user : ahtUsers) {
			UserDTO userDTO = fromAhtUserToUserDTO(user);
			dtos.add(userDTO);
		}
		return dtos;
	}
	
	
	public static UserDTO fromAhtUserToUserDTO(AhtUser ahtUser) {
		ModelMapper modelMapper = new ModelMapper();		
		Set<UserRoleDTO> userRoleDTOs = conVertListAhtUserRoleToListUserRoleDTO(ahtUser.getAhtUserRoles());
		
		UserDTO userDTO = modelMapper.map(ahtUser, UserDTO.class);
		
		userDTO.setUserRoleDTOs(userRoleDTOs);
		return userDTO;
	}
	
	public static Set<UserRoleDTO> conVertListAhtUserRoleToListUserRoleDTO(Set<AhtUserRole> ahtUserRoles){
		Set<UserRoleDTO> list = new HashSet<UserRoleDTO>();
		for (AhtUserRole ahtUserRole : ahtUserRoles) {
			UserRoleDTO userRoleDTO = fromAhtUserRoleToUserRoleDTO(ahtUserRole);
			list.add(userRoleDTO);
		}
		return list;
	}
	
	public static UserRoleDTO fromAhtUserRoleToUserRoleDTO(AhtUserRole ahtUserRole) {
		ModelMapper modelMapper = new ModelMapper();
		UserRoleDTO userRoleDTO = modelMapper.map(ahtUserRole, UserRoleDTO.class);
		return userRoleDTO;
	}
	
	public static PartDTO fromAhtPartToPartDTO(AhtParts ahtParts) {
		ModelMapper modelMapper = new ModelMapper();
		PartDTO partDTO = modelMapper.map(ahtParts, PartDTO.class);
		return partDTO;
	}

	public static TrainingEmpDTO fromTrainingEntityToTrainingDTO(AhtTraningEmp ahtTraningEmp) {
		ModelMapper modelMapper = new ModelMapper();
		TrainingEmpDTO trainingEmpDTO = modelMapper.map(ahtTraningEmp, TrainingEmpDTO.class);
		
		EmployeeDTO employeeDTO = fromAhtEmployeeToEmployeeDTO(ahtTraningEmp.getAhtEmployee());
		trainingEmpDTO.setEmployeeDTO(employeeDTO);
		
		TrainingDTO trainingDTO = fromAhtTrainingToTrainingDTO(ahtTraningEmp.getAhtTraining());
		trainingEmpDTO.setTrainingDTO(trainingDTO);
		
		return trainingEmpDTO;
	}
	
	public static TrainingDTO fromAhtTrainingToTrainingDTO(AhtTraining ahtTraining) {
		ModelMapper modelMapper = new ModelMapper();
		TrainingDTO dto = modelMapper.map(ahtTraining, TrainingDTO.class);
		return dto;
	}
	
	public static List<EmployeeDTO> fromAhtEmployeeListToEmployeeDTOList(Page<AhtEmployee> ahtEmployees){
		List<EmployeeDTO> employeeDTOs = new ArrayList<EmployeeDTO>();
		for (AhtEmployee employee : ahtEmployees) {
			EmployeeDTO employeeDTO = Convert.fromAhtEmployeeToEmployeeDTO(employee);
			employeeDTOs.add(employeeDTO);
		}
		return employeeDTOs;
	}
	
	public static AhtDepartment fromDepartmentDTOToAhtDepartment(DepartmentDTO departmentDTO) {
		ModelMapper modelMapper = new ModelMapper();
		AhtDepartment ahtDepartment = modelMapper.map(departmentDTO, AhtDepartment.class);
		return ahtDepartment;
	}
	
	public static DepartmentDTO fromAhtDepartmentToDepartmentDTO(AhtDepartment ahtDepartment) {
		ModelMapper modelMapper = new ModelMapper();
		DepartmentDTO departmentDTO = modelMapper.map(ahtDepartment, DepartmentDTO.class);
		return departmentDTO;
	}
	
	public static AhtTraningEmp fromTrainingDTOToTrainingEntity(TrainingEmpDTO trainingEmpDTO) {
		ModelMapper modelMapper = new ModelMapper();
		AhtTraningEmp ahtTraningEmp = modelMapper.map(trainingEmpDTO, AhtTraningEmp.class);
	
		AhtEmployee ahtEmployee = fromEmployeeDTOToAhtEmployee(trainingEmpDTO.getEmployeeDTO()); 
		ahtTraningEmp.setAhtEmployee(ahtEmployee);
		
		AhtTraining ahtTraining = fromTrainingDTOToAhtTraining(trainingEmpDTO.getTrainingDTO());
		ahtTraningEmp.setAhtTraining(ahtTraining);
		
		return ahtTraningEmp;
	}
	
	public static AhtTraining fromTrainingDTOToAhtTraining(TrainingDTO trainingDTO) {
		ModelMapper modelMapper = new ModelMapper();
		AhtTraining ahtTraining = modelMapper.map(trainingDTO, AhtTraining.class);
		return ahtTraining;
	}
	
	public static ContractEmpDTO fromAhtContractEmpToContractEmpDTO(AhtContractEmp ahtContractEmp) {
		ModelMapper modelMapper = new ModelMapper();
		ContractEmpDTO contractEmpDTO = modelMapper.map(ahtContractEmp, ContractEmpDTO.class);
		
		EmployeeDTO employeeDTO = fromAhtEmployeeToEmployeeDTO(ahtContractEmp.getAhtEmployee());
		contractEmpDTO.setEmployeeDTO(employeeDTO);
		
		ContractDTO contractDTO  =fromAhtContractToContractDTO(ahtContractEmp.getAhtContract());
		contractEmpDTO.setContractDTO(contractDTO);
		
		return contractEmpDTO;
	}
	
	public static ContractDTO fromAhtContractToContractDTO(AhtContract ahtContract) {
		ModelMapper modelMapper = new ModelMapper();
		ContractDTO contractDTO = modelMapper.map(ahtContract, ContractDTO.class);
		return contractDTO;
	}
	
	public static AhtContractEmp fromContractEmpDTOToAhtContractEmp(ContractEmpDTO contractEmpDTO) {
		ModelMapper modelMapper = new ModelMapper();
		AhtContractEmp ahtContractEmp = modelMapper.map(contractEmpDTO, AhtContractEmp.class);
		
		AhtEmployee ahtEmployee = fromEmployeeDTOToAhtEmployee(contractEmpDTO.getEmployeeDTO());
		
		AhtContract ahtContract = fromContractDTOToAhtContract(contractEmpDTO.getContractDTO());
		
		ahtContractEmp.setAhtContract(ahtContract);
		ahtContractEmp.setAhtEmployee(ahtEmployee);
		return ahtContractEmp;
	}
	
	public static EmployeeDTO fromAhtEmployeeToEmployeeDTO(AhtEmployee ahtEmployee){
		ModelMapper modelMapper = new ModelMapper();
				
		EmployeeDTO em = modelMapper.map(ahtEmployee, EmployeeDTO.class);
		return em;
	}
	
	public static AhtEmployee fromEmployeeDTOToAhtEmployee(EmployeeDTO employeeDTO) {
		ModelMapper modelMapper = new ModelMapper();
		AhtEmployee ahtEmployee = modelMapper.map(employeeDTO, AhtEmployee.class);
		return ahtEmployee;
	}
	
	public static AhtContract fromContractDTOToAhtContract(ContractDTO contractDTO) {
		ModelMapper modelMapper = new ModelMapper();
		AhtContract ahtContract = modelMapper.map(contractDTO, AhtContract.class);
		return ahtContract;
	}
	
		//lấy index trang Previous
		public static int layIndexPrevious(Integer index,int soTrang) {
			if(index == null || index == 1) {
				return 1;
			}else if(index!=1 && index !=null) {
					return (index -1);
			}
			return 1;
		}
	
		//lấy index trang Next
		public static int layIndexNext(Integer index,int soTrang) {
			if(index == null || index == 1) {
				return 2;
			}else if(index!=1 && index !=null) {
				if(index == soTrang) {
					return index;
				}
				return (index+1);
			}
			return 1;
		}
		
		@SuppressWarnings("unused")
		public static Pageable layPageable(Integer index) {
			Pageable pageable = new PageRequest(0,5);
			if(index == null) {
				return new PageRequest(0,5);
			}else if(index != null) {
				return new PageRequest(index-1,5);
			}
			return pageable;
		}
}
