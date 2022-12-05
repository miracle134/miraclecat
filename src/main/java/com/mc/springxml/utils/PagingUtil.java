package com.mc.springxml.utils;

public class PagingUtil {

	private int totalRows = 0;
	private int currentPage = 1;
	private int pageSize = 10;
	private int blockSize = 10;	
	private int totalPages;
	private int totalBlocks;
	private int startPageNum;
	private int endPageNum;
	private int currentBlock;
	
	// for design
	public String firstLink = "<<";
	public String firstOffLink = "";
	public String prevLink = "<";
	public String prevOffLink = "";
	public String nextLink = ">";
	public String nextOffLink = "";
	public String lastLink = ">>";
	public String lastOffLink = "";
	
	/*public String delimiter = "|";*/
	public String delimiter = "";
	
	// current Page Wrapper
	public String preWrap = "<b>";
	public String postWrap = "</b>";
	
	public String linkPage = "";
	public String queryString = "";
	public String amp = "";
	
	// result temp object
	public StringBuffer pageString = new StringBuffer();
	
	public PagingUtil(int currentPage,int totalRows)
	{
		
		this.currentPage = currentPage;
		this.pageSize = Integer.parseInt(PropertiesUtil.getProperty("defautPageSize"));
		this.blockSize = Integer.parseInt(PropertiesUtil.getProperty("defautBlockSize"));
		this.totalRows = totalRows;
		
		initialize();
	} 
	
	public PagingUtil(int currentPage,int totalRows , int pageSize , int blockSize)
	{
		
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.blockSize = blockSize;
		this.totalRows = totalRows;
		
		initialize();
	} 
	
	public void initialize()
	{	
		this.totalPages = (int)Math.ceil((double)this.totalRows / this.pageSize);
		this.totalBlocks = (int)Math.ceil((double)this.totalPages / this.blockSize);
		this.currentBlock = (int)Math.ceil((double)((this.currentPage - 1) / this.blockSize)) + 1;		
		this.startPageNum = ((this.currentBlock - 1) * this.pageSize) + 1;
		this.endPageNum = this.startPageNum + this.pageSize;
	}
	
	public void prePrint()
	{
		// set first block link
		if(this.currentBlock > 1)
			//pageString.append("5555<a href=\"" + this.linkPage + "?" + this.queryString + this.amp + "pageNum=" + (((this.currentBlock - 2) * this.pageSize) + 1) + "\">" + this.firstLink + "</a> ");
			pageString.append(" <li class=\"page-item page-prev\"><a href=\"javascript:goPage('"+(((this.currentBlock - 2) * this.pageSize) + 1)+"')\" class=\"page-link\">" + this.firstLink + "</a></li> ");
		else
			pageString.append(this.firstOffLink + " ");
			
		
		// set prev page link
		if(this.currentPage > 1)
			//pageString.append("4444<a href=\"" + this.linkPage + "?" + this.queryString + this.amp + "pageNum=" + (this.currentPage  - 1) + "\">" + this.prevLink + "</a> ");
			pageString.append("<li class=\"page-item page-prev\"><a href=\"javascript:goPage('"+(this.currentPage  - 1)+"')\" class=\"page-link\">" + this.prevLink + "</a></li> ");
		else
//			pageString.append(this.prevOffLink + " ");
			if(this.currentPage == this.startPageNum) {
				pageString.append("<li class=\"page-item page-prev\"><a href=\"javascript:goPage('"+(this.currentPage)+"')\" class=\"page-link\">" + this.prevLink + "</a></li> ");
			} else {
				pageString.append("<li class=\"page-item page-prev\"><a href=\"javascript:goPage('"+(this.currentPage  - 1)+"')\" class=\"page-link\">" + this.prevLink + "</a></li> ");
			}
	}
	
	public void prePrint2()
	{
		// set first block link
		if(this.currentBlock > 1)
			//pageString.append("5555<a href=\"" + this.linkPage + "?" + this.queryString + this.amp + "pageNum=" + (((this.currentBlock - 2) * this.pageSize) + 1) + "\">" + this.firstLink + "</a> ");
			pageString.append(" <li class=\"page-item page-prev\"><a href=\"javascript:goPage2('"+(((this.currentBlock - 2) * this.pageSize) + 1)+"')\" class=\"page-link\">" + this.firstLink + "</a></li> ");
		else
			pageString.append(this.firstOffLink + " ");
		
		
		// set prev page link
		if(this.currentPage > 1)
			//pageString.append("4444<a href=\"" + this.linkPage + "?" + this.queryString + this.amp + "pageNum=" + (this.currentPage  - 1) + "\">" + this.prevLink + "</a> ");
			pageString.append("<li class=\"page-item page-prev\"><a href=\"javascript:goPage2('"+(this.currentPage  - 1)+"')\" class=\"page-link\">" + this.prevLink + "</a></li> ");
		else
//			pageString.append(this.prevOffLink + " ");
			if(this.currentPage == this.startPageNum) {
				pageString.append("<li class=\"page-item page-prev\"><a href=\"javascript:goPage2('"+(this.currentPage)+"')\" class=\"page-link\">" + this.prevLink + "</a></li> ");
			} else {
				pageString.append("<li class=\"page-item page-prev\"><a href=\"javascript:goPage2('"+(this.currentPage  - 1)+"')\" class=\"page-link\">" + this.prevLink + "</a></li> ");
			}
	}
	
	public void postPrint()
	{
		// set next page link
		if(this.currentPage < this.totalPages )
			pageString.append(" <li class=\"page-item page-next\"><a href=\"javascript:goPage('"+(this.currentPage  + 1)+"')\" class=\"page-link\">" + this.nextLink + "</a></li> ");
			//pageString.append("3333<a href=\"" + this.linkPage + "?" + this.queryString + this.amp + "pageNum=" + (this.currentPage + 1) + "\">" + this.nextLink + "</a> ");
		else
//			pageString.append(this.nextOffLink + " ");
			if(this.currentPage == this.totalPages) {
				pageString.append(" <li class=\"page-item page-next\" disabled><a href=\"javascript:goPage('"+(this.currentPage)+"')\" class=\"page-link\">" + this.nextLink + "</a></li> ");
			} else {
				pageString.append(" <li class=\"page-item page-next\"><a href=\"javascript:goPage('"+(this.currentPage  + 1)+"')\" class=\"page-link\">" + this.nextLink + "</a></li> ");
			}
		// set last page link
		if(this.currentBlock < this.totalBlocks)
			pageString.append(" <li class=\"page-item page-next\"><a href=\"javascript:goPage('"+((this.currentBlock * this.pageSize) + 1)+"')\" class=\"page-link\">" + this.lastLink + "</a></li> ");
			//pageString.append("2222<a href=\"" + this.linkPage + "?" + this.queryString + this.amp + "pageNum=" + ((this.currentBlock * this.pageSize) + 1) + "\">" + this.lastLink + "</a> ");
		else
			pageString.append(this.lastOffLink);
	}
	
	public void postPrint2()
	{
		// set next page link
		if(this.currentPage < this.totalPages )
			pageString.append(" <li class=\"page-item page-next\"><a href=\"javascript:goPage2('"+(this.currentPage  + 1)+"')\" class=\"page-link\">" + this.nextLink + "</a></li> ");
		//pageString.append("3333<a href=\"" + this.linkPage + "?" + this.queryString + this.amp + "pageNum=" + (this.currentPage + 1) + "\">" + this.nextLink + "</a> ");
		else
//			pageString.append(this.nextOffLink + " ");
			if(this.currentPage == this.totalPages) {
				pageString.append(" <li class=\"page-item page-next\" disabled><a href=\"javascript:goPage2('"+(this.currentPage)+"')\" class=\"page-link\">" + this.nextLink + "</a></li> ");
			} else {
				pageString.append(" <li class=\"page-item page-next\"><a href=\"javascript:goPage2('"+(this.currentPage  + 1)+"')\" class=\"page-link\">" + this.nextLink + "</a></li> ");
			}
		// set last page link
		if(this.currentBlock < this.totalBlocks)
			pageString.append(" <li class=\"page-item page-next\"><a href=\"javascript:goPage2('"+((this.currentBlock * this.pageSize) + 1)+"')\" class=\"page-link\">" + this.lastLink + "</a></li> ");
		//pageString.append("2222<a href=\"" + this.linkPage + "?" + this.queryString + this.amp + "pageNum=" + ((this.currentBlock * this.pageSize) + 1) + "\">" + this.lastLink + "</a> ");
		else
			pageString.append(this.lastOffLink);
	}
	
	public void printList()
	{	
		for(int i = startPageNum ; i <= endPageNum ; i++)
		{
			if(i > this.totalPages || i == endPageNum)
				break;
			else if(i > startPageNum)
				pageString.append(this.delimiter);
			
			if(i == this.currentPage)			
				//pageString.append(" " + this.preWrap + i +  this.postWrap + " ");
			    pageString.append("<li class=\"page-item active\"><a href=\"javascript:goPage('"+i+"')\" class=\"page-link\">"+ i +"</a></li>");
			else
				//pageString.append(" <a href=\"" + this.linkPage + "?" + this.queryString + this.amp + "pageNum=" + i + "\">" + i + "</a> ");
				pageString.append("<li class=\"page-item\"><a href=\"javascript:goPage('"+i+"')\" class=\"page-link\">" + i + "</a></li> ");
		}
	}
	
	public void printList2()
	{	
		for(int i = startPageNum ; i <= endPageNum ; i++)
		{
			if(i > this.totalPages || i == endPageNum)
				break;
			else if(i > startPageNum)
				pageString.append(this.delimiter);
			
			if(i == this.currentPage)			
				//pageString.append(" " + this.preWrap + i +  this.postWrap + " ");
				pageString.append("<li class=\"page-item active\"><a href=\"javascript:goPage2('"+i+"')\" class=\"page-link\">"+ i +"</a></li>");
			else
				//pageString.append(" <a href=\"" + this.linkPage + "?" + this.queryString + this.amp + "pageNum=" + i + "\">" + i + "</a> ");
				pageString.append("<li class=\"page-item\"><a href=\"javascript:goPage2('"+i+"')\" class=\"page-link\">" + i + "</a></li> ");
		}
	}
	
	public String print()
	{
		// set amp if already to set up queryString property
		if(!this.queryString.equals(""))
			this.amp = "&";
		
		if(this.totalPages > 1)
		{
			this.prePrint();
			this.printList();
			this.postPrint();
		}
		
		return(pageString.toString());
	}
	
	public String print2()
	{
		// set amp if already to set up queryString property
		if(!this.queryString.equals(""))
			this.amp = "&";
		
		if(this.totalPages > 1)
		{
			this.prePrint2();
			this.printList2();
			this.postPrint2();
		}
		
		return(pageString.toString());
	}

}

