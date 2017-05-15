<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
			<div class="row">
				<div class="col-md-1"></div>
				
				<!--  TOUT LE MONDE -->
				<div class="col-md-2">
					<form method="post" action="<%= getServletContext().getContextPath()%>/do/listeEtudiants">
						<input type="hidden" name="idEtudiant" value="tous"/>
						<button type="submit" class="btn btn-default">
							Toutes les licences
						</button>
					</form>
				</div>
				
				<!--  SIMO -->
				<div class="col-md-2">
					<form method="post" action="<%= getServletContext().getContextPath()%>/do/listeEtudiants?licence=1">
						<input type="hidden" name="idEtudiant" value="simo"/>
						<button type="submit" class="btn btn-primary">
							BELLI SIMO
						</button>
					</form>
				</div>
				
				<!--  BIG-DATA -->
				<div class="col-md-2">
					<form method="post" action="<%= getServletContext().getContextPath()%>/do/listeEtudiants?licence=2">
						<input type="hidden" name="idEtudiant" value="big-data"/>
						<button type="submit" class="btn btn-success">
							MIAOU
						</button>
					</form>
				</div>
				
				<!--  MIAW -->
				<div class="col-md-2">
					<form method="post" action="<%= getServletContext().getContextPath()%>/do/listeEtudiants?licence=3">
						<input type="hidden" name="idEtudiant" value="miaw"/>
						<button type="submit" class="btn btn-info">
							BIG-D
						</button>
					</form>
				</div>
				
				<!--  ASSR -->
				<div class="col-md-2">
					<form method="post" action="<%= getServletContext().getContextPath()%>/do/listeEtudiants?licence=4">
						<input type="hidden" name="idEtudiant" value="assr"/>
						<button type="submit" class="btn btn-warning">
							LEZOTR
						</button>
					</form>
				</div>
				
				<div class="col-md-1"></div>
		</div>