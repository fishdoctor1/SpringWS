package th.co.por.web.impl.util;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import th.co.por.service.util.IEmployeeService;
import th.co.por.web.bean.util.EmployeeResReq;
import th.co.por.web.context.SpringApplicationContext;
import th.co.por.web.spec.util.IEmployeeWeb;

public class EmployeeWebImpl implements IEmployeeWeb{

	@Override
	public Response queryEmployee(String in) {		
		try {
			IEmployeeService employeeService = (IEmployeeService) SpringApplicationContext
					.getBean("employee");

			EmployeeResReq req = new EmployeeResReq();
			EmployeeResReq res = new EmployeeResReq();
			Gson gson = new Gson();
			try {
				req = gson.fromJson(in, EmployeeResReq.class);
				System.out.println("hello");
			} catch (Exception e) {
				return Response.status(200).entity(
						"{\"resultCode\":\"50000\",\"resultDescription\":\"JSON incorrect format\",\"developerMessage\":\"JSON incorrect format\"}")
						.header("Content-Type", MediaType.APPLICATION_JSON + ";charset=utf-8").build();
			}

//			if (req != null && BeanUtil.isNotEmpty(req)) {
//				try {
//					ProcessResult result = new ProcessResult(false, null, "");
//					result = shopInService.searchTransferOut(req);
//
//					if (result.getResultObject() == null && result.getMessage() == "Data not found.") {
//						return Response.status(200).entity(
//								"{\"resultCode\":\"50000\",\"resultDescription\":\"Data not found.\",\"developerMessage\":\"Data not found.\"}")
//								.header("Content-Type", MediaType.APPLICATION_JSON + ";charset=utf-8").build();
//					}
//
//					res.setResultCode("20000");
//					res.setDeveloperMessage("Success");
//					res.setResultDescription("Success");
//					res.setSearchTransferOutBeanList(
//							(List<QuerySearchTransferOutForShopInBean>) result.getResultObject());
//
//				} catch (Exception e) {
//					res.setDeveloperMessage(e.getMessage());
//					res.setResultCode("50000");
//					res.setResultDescription(e.getMessage());
//				}
//
//				return Response.status(200).entity(gson.toJson(res))
//						.header("Content-Type", MediaType.APPLICATION_JSON + ";charset=utf-8").build();
//
//			} else {
//				return Response.status(200).entity(
//						"{\"resultCode\":\"50000\",\"resultDescription\":\"Data incorrect\",\"developerMessage\":\"Data incorrect\"}")
//						.header("Content-Type", MediaType.APPLICATION_JSON + ";charset=utf-8").build();
//			}
			return Response.status(200).entity(
					"{\"resultCode\":\"20000\",\"resultDescription\":\"System hello\",\"developerMessage\":\"System error\"}")
					.header("Content-Type", MediaType.APPLICATION_JSON + ";charset=utf-8").build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).entity(
					"{\"resultCode\":\"50000\",\"resultDescription\":\"System error\",\"developerMessage\":\"System error\"}")
					.header("Content-Type", MediaType.APPLICATION_JSON + ";charset=utf-8").build();
		}
	}

}
