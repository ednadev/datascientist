package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Item;
import model.ItemDao;

public class ItemInfoController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int itemnum = Integer.parseInt(request.getParameter("id"));
		int count = Integer.parseInt(request.getParameter("count"));
		
		ItemDao.getInstance().updateCount(count, itemnum);
		Item item = ItemDao.getInstance().getItem(itemnum);
		
		request.setAttribute("item", item);
		return new ModelAndView("itemView.jsp");
	}

}
