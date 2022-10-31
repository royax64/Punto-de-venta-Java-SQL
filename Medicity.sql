--CREACION DE BASE DE DATOS MEDICITY
create database Medicity
use Medicity

CREATE TABLE Marcas 
	(ID_Marca int PRIMARY KEY NOT NULL,
	Descripcion varchar(50) NOT NULL)

INSERT INTO Marcas VALUES(1,'Modern Research')
INSERT INTO Marcas VALUES(2,'Generica')
INSERT INTO Marcas VALUES(3,'Laboratorios Best')
INSERT INTO Marcas VALUES(4,'Novartis')
INSERT INTO Marcas VALUES(5,'Coca-Cola')
INSERT INTO Marcas VALUES(6,'Sabritas')


CREATE TABLE Categorias_Prod 
	(ID_Categoria int PRIMARY KEY NOT NULL,
	Descripcion varchar(50) NOT NULL)

INSERT INTO Categorias_Prod VALUES(1,'Abarrotes')
INSERT INTO Categorias_Prod VALUES(2,'Higiene Personal')
INSERT INTO Categorias_Prod VALUES(3,'Medicina')
INSERT INTO Categorias_Prod VALUES(4,'Bebes')
INSERT INTO Categorias_Prod VALUES(5,'Hogar')

CREATE TABLE Presentaciones 
	(ID_Presentacion int PRIMARY KEY NOT NULL,
	Descripcion varchar(50) NOT NULL)

INSERT INTO Presentaciones VALUES(1,'Ampolleta')
INSERT INTO Presentaciones VALUES(2,'Tableta')
INSERT INTO Presentaciones VALUES(3,'Jarabe')
INSERT INTO Presentaciones VALUES(4,'Capsula')

CREATE TABLE Proveedores
	(ID_Proveedor int PRIMARY KEY NOT NULL,
	Nombre varchar(100) NOT NULL,
	ID_Marca int FOREIGN KEY REFERENCES Marcas(ID_Marca) NOT NULL,
	Telefono varchar(15) NOT NULL)

insert into Proveedores values (1, 'Stephi Luttgert', 3 , '212-709-1857');
insert into Proveedores values (2, 'Roseann Hatwells', 4 ,  '417-444-6057');
insert into Proveedores values (3, 'Kathie De Souza', 1, '846-955-1529');
insert into Proveedores values (4, 'Hilliary Kippling', 4, '323-771-5503');
insert into Proveedores values (5, 'Odessa Salvadori', 2, '541-286-1185');
insert into Proveedores values (6, 'Benito Juarez', 5, '694-395-2967');
insert into Proveedores values (7, 'Enrique Peña Nieto', 6, '767-294-7950');


CREATE TABLE Productos_Header 
	(ID_Producto int PRIMARY KEY NOT NULL,
	Nombre varchar(50) NOT NULL,
	Precio_unitario float NOT NULL,
	ID_Proveedor int FOREIGN KEY REFERENCES Proveedores(ID_Proveedor),
	ID_Categoria int FOREIGN KEY REFERENCES Categorias_Prod(ID_Categoria) NOT NULL,
	ID_Marca int FOREIGN KEY REFERENCES Marcas(ID_Marca) NOT NULL,
	Disponibilidad int NOT NULL)

insert into Productos_Header (ID_Producto, Nombre, Precio_unitario, ID_Proveedor, ID_Categoria, ID_Marca, Disponibilidad) values (1, 'Cheetos Flamin Hot', 9.99, 7, 1, 6, 10);
insert into Productos_Header (ID_Producto, Nombre, Precio_unitario, ID_Proveedor, ID_Categoria, ID_Marca, Disponibilidad) values (2, 'Trapeador', 50.76, 5, 5, 2, 47);
insert into Productos_Header (ID_Producto, Nombre, Precio_unitario, ID_Proveedor, ID_Categoria, ID_Marca, Disponibilidad) values (3, 'Coca-Cola Light 600ml', 29.25, 6, 1, 5, 33);
insert into Productos_Header (ID_Producto, Nombre, Precio_unitario, ID_Proveedor, ID_Categoria, ID_Marca, Disponibilidad) values (4, 'Itraconzol', 970.33, 1, 3, 3, 23);
insert into Productos_Header (ID_Producto, Nombre, Precio_unitario, ID_Proveedor, ID_Categoria, ID_Marca, Disponibilidad) values (5, 'Cloropiramina', 797.14, 4, 3, 4, 50);



CREATE TABLE Productos_Med
	(ID_Producto int PRIMARY KEY FOREIGN KEY REFERENCES Productos_Header(ID_Producto) NOT NULL,
	Ingrediente varchar(100) NOT NULL,
	ID_Presentacion int FOREIGN KEY REFERENCES Presentaciones(ID_Presentacion),
	Caducidad date,
	CantidadxU varchar(20), 
	PesoxU varchar(20))

INSERT INTO Productos_Med (ID_Producto,Ingrediente,ID_Presentacion,Caducidad,CantidadxU,PesoxU) VALUES (4,'Itraconazol-Excipiente CBP',4,'23-NOV-22','15','100 mg')
INSERT INTO Productos_Med (ID_Producto,Ingrediente,ID_Presentacion,Caducidad,CantidadxU,PesoxU) VALUES (5,'Clorhidrato de cloropiramina',2,'24-APR-2021','20','25 mg')

CREATE TABLE Empleados
	(ID_Empleado int PRIMARY KEY NOT NULL,
	Nombre varchar(100) NOT NULL,
	Posicion varchar(20) NOT NULL,
	Telefono varchar (15) NOT NULL)

insert into Empleados (ID_Empleado, Nombre, Posicion, Telefono) values (1, 'Chandal Claricoates', 'Cajero', '410-185-4884');
insert into Empleados (ID_Empleado, Nombre, Posicion, Telefono) values (2, 'Genny Fishleigh', 'Cajero', '792-216-2241');
insert into Empleados (ID_Empleado, Nombre, Posicion, Telefono) values (3, 'Madeleine Dellenbrook', 'Recursos Humanos', '935-583-7171');
insert into Empleados (ID_Empleado, Nombre, Posicion, Telefono) values (4, 'Winne Brocklebank', 'Medico', '211-171-9591');
insert into Empleados (ID_Empleado, Nombre, Posicion, Telefono) values (5, 'Kattie Farrens', 'Gerente', '600-937-0510');

CREATE TABLE Clientes
	(ID_Cliente int PRIMARY KEY NOT NULL,
	Nombre varchar(100) NOT NULL,
	Telefono varchar (15) NOT NULL)

insert into Clientes (ID_Cliente, Nombre, Telefono) values (1, 'Madel Auchterlony', '782-606-0720');
insert into Clientes (ID_Cliente, Nombre, Telefono) values (2, 'Wandie Bugbird', '720-431-3481');
insert into Clientes (ID_Cliente, Nombre, Telefono) values (3, 'Chariot Ledrun', '864-769-9081');
insert into Clientes (ID_Cliente, Nombre, Telefono) values (4, 'Jeffie Twitchett', '363-215-8616');
insert into Clientes (ID_Cliente, Nombre, Telefono) values (5, 'Tiphani Persent', '349-202-8789');

CREATE TABLE Ventas_Header
	(ID_Venta int PRIMARY KEY NOT NULL,
	ID_Cliente int FOREIGN KEY REFERENCES Clientes(ID_Cliente) NOT NULL,
	ID_Empleado int FOREIGN KEY REFERENCES Empleados(ID_Empleado) NOT NULL,
	Fecha date NOT NULL,
	Hora time NOT NULL)

insert into Ventas_Header (ID_Venta, ID_Cliente, ID_Empleado, Fecha, Hora) values (1, 1, 5, '2022-04-23', '3:43');
insert into Ventas_Header (ID_Venta, ID_Cliente, ID_Empleado, Fecha, Hora) values (2, 1, 5, '2022-04-23', '21:43');
insert into Ventas_Header (ID_Venta, ID_Cliente, ID_Empleado, Fecha, Hora) values (3, 5, 4, '2022-04-26', '0:31');
insert into Ventas_Header (ID_Venta, ID_Cliente, ID_Empleado, Fecha, Hora) values (4, 3, 3, '2022-04-26', '18:58');
insert into Ventas_Header (ID_Venta, ID_Cliente, ID_Empleado, Fecha, Hora) values (5, 2, 1, '2022-04-20', '21:22');

CREATE TABLE Ventas_Detalle
	(ID_Venta int FOREIGN KEY REFERENCES Ventas_Header(ID_Venta) NOT NULL,
	ID_Producto int FOREIGN KEY REFERENCES Productos_Header(ID_Producto) NOT NULL,
	Cantidad int NOT NULL,
	Precio_Unitario float NOT NULL,
	CONSTRAINT PK_VENTA_PRODUCTO PRIMARY KEY (ID_Venta,ID_Producto))

insert into Ventas_Detalle (ID_Venta, ID_Producto, Cantidad, Precio_Unitario) values (3, 1, 6, 10);
insert into Ventas_Detalle (ID_Venta, ID_Producto, Cantidad, Precio_Unitario) values (2, 5, 3, 800);
insert into Ventas_Detalle (ID_Venta, ID_Producto, Cantidad, Precio_Unitario) values (5, 3, 5, 29.25);
insert into Ventas_Detalle (ID_Venta, ID_Producto, Cantidad, Precio_Unitario) values (4, 4, 8, 970.33);
insert into Ventas_Detalle (ID_Venta, ID_Producto, Cantidad, Precio_Unitario) values (2, 2, 3, 50);
insert into Ventas_Detalle (ID_Venta, ID_Producto, Cantidad, Precio_Unitario) values (1, 2, 10, 50);

CREATE TABLE Roles
	(ID_Rol int PRIMARY KEY NOT NULL,
	Descripcion varchar(50))

INSERT INTO Roles VALUES (1,'GERENTE')
INSERT INTO Roles VALUES (2,'EMPLEADO')

CREATE TABLE Permisos
	(ID_Permiso int NOT NULL,
	Descripcion varchar(50) NOT NULL,
	ID_Rol int FOREIGN KEY REFERENCES Roles(ID_Rol) NOT NULL,
	CONSTRAINT PK_ROL_PERMISO PRIMARY KEY (ID_Rol,ID_Permiso))

INSERT INTO Permisos VALUES (1,'SELECT',1)
INSERT INTO Permisos VALUES (2,'EXEC',1)
INSERT INTO Permisos VALUES (3,'ALTER',1)
INSERT INTO Permisos VALUES (6,'UPDATE',1)
INSERT INTO Permisos VALUES (7,'DELETE',1)
INSERT INTO Permisos VALUES (8,'GRANT',1)
INSERT INTO Permisos VALUES (9,'REVOKE',1)
INSERT INTO Permisos VALUES (1,'SELECT',2)
INSERT INTO Permisos VALUES (2,'EXEC',2)
INSERT INTO Permisos VALUES (6,'UPDATE',2)


CREATE TABLE Usuarios
	(ID_Empleado int PRIMARY KEY FOREIGN KEY REFERENCES Empleados(ID_Empleado) NOT NULL,
	ID_Rol int FOREIGN KEY REFERENCES Roles(ID_Rol))

INSERT INTO Usuarios VALUES (1,2)
INSERT INTO Usuarios VALUES (5,1)

CREATE TABLE Pedidos_Header
	(ID_Pedido int PRIMARY KEY NOT NULL,
	ID_Proveedor int FOREIGN KEY REFERENCES Proveedores(ID_Proveedor) NOT NULL,
	ID_Empleado int FOREIGN KEY REFERENCES Empleados(ID_Empleado) NOT NULL,
	Fecha_Pedido date NOT NULL,
	Fecha_Entregado date)

insert into Pedidos_Header (ID_Pedido, ID_Proveedor, ID_Empleado, Fecha_Pedido,Fecha_Entregado) values (1, 6, 2, '2022-04-21', '2022-04-28');
insert into Pedidos_Header (ID_Pedido, ID_Proveedor, ID_Empleado, Fecha_Pedido,Fecha_Entregado) values (2, 2, 1, '2022-04-20', '2022-04-23');
insert into Pedidos_Header (ID_Pedido, ID_Proveedor, ID_Empleado, Fecha_Pedido,Fecha_Entregado) values (3, 1, 5, '2022-04-25', '2022-04-30');
insert into Pedidos_Header (ID_Pedido, ID_Proveedor, ID_Empleado, Fecha_Pedido,Fecha_Entregado) values (4, 2, 3, '2022-04-20', '2022-04-25');
insert into Pedidos_Header (ID_Pedido, ID_Proveedor, ID_Empleado, Fecha_Pedido,Fecha_Entregado) values (5, 7, 1, '2022-04-26', null);


CREATE TABLE Pedidos_Detalle
	(ID_Pedido int FOREIGN KEY REFERENCES Pedidos_Header(ID_Pedido) NOT NULL,
	ID_Producto int FOREIGN KEY REFERENCES Productos_Header(ID_Producto) NOT NULL,
	Cantidad int NOT NULL,
	Costo_Mayoreo float NOT NULL,
	CONSTRAINT PK_PEDIDO_PRODUCTO PRIMARY KEY (ID_Pedido,ID_Producto))

insert into Pedidos_Detalle (ID_Pedido, ID_Producto, Cantidad, Costo_Mayoreo) values (4, 4, 41, 40);
insert into Pedidos_Detalle (ID_Pedido, ID_Producto, Cantidad, Costo_Mayoreo) values (4, 1, 11, 9);
insert into Pedidos_Detalle (ID_Pedido, ID_Producto, Cantidad, Costo_Mayoreo) values (5, 5, 49, 9.5);
insert into Pedidos_Detalle (ID_Pedido, ID_Producto, Cantidad, Costo_Mayoreo) values (3, 4, 20, 900);
insert into Pedidos_Detalle (ID_Pedido, ID_Producto, Cantidad, Costo_Mayoreo) values (1, 3, 47, 25);


--CREANDO USUARIOS
create login [2] with password = '1234'
create user [2] for login [2]

create login [5] with password = '1234'
create user [5] for login [5]

--CREANDO ROLES
create role GERENTE
create role EMPLEADO



--DANDO PERMISOS A GERENTE
--NOTA: HAGAN ESTA PARTE BAJO EL USUARIO QUE CREÓ LA BASE DE DATOS PARA QUE JALE
GRANT CREATE TABLE, CREATE VIEW TO GERENTE
GRANT SELECT TO GERENTE
GRANT EXEC TO GERENTE
GRANT ALTER TO GERENTE
GRANT INSERT TO gerente
grant update to gerente
GRANT CONTROL TO GERENTE
REVOKE DELETE TO GERENTE

--NOTA IMPORTANTE, ESTOS PERMISOS SON A NIVEL DE SERVIDOR 
--Y PARA QUE FUNCIONE EL PROGRAMA DEBEN DARSELOS A UN GERENTE. EJ: [5]
use [master];
GRANT ALTER ANY CREDENTIAL TO [5];
GRANT ALTER ANY DATABASE TO [5];
GRANT ALTER ANY LOGIN TO [5];
GRANT ALTER ANY SERVER ROLE TO [5];
GRANT CONNECT ANY DATABASE TO [5];
GRANT CONNECT SQL TO [5];
GRANT CONTROL SERVER TO [5];
USE [Medicity];

--DANDO PERMISOS A EMPLEADO
--NOTA: HAGAN ESTA PARTE BAJO EL USUARIO QUE CREÓ LA BASE DE DATOS PARA QUE JALE
GRANT SELECT TO EMPLEADO
GRANT EXEC TO EMPLEADO
GRANT UPDATE TO EMPLEADO
GRANT INSERT TO EMPLEADO
revoke delete to empleado
revoke create table to empleado
revoke CONTROL to empleado
revoke alter to empleado

--DANDO ROLES A USUARIOS
alter role GERENTE ADD MEMBER [5]
ALTER ROLE EMPLEADO ADD MEMBER [2]

--CREANDO PROCEDIMIENTOS ALMACENADOS PARA FACILITAR LAS COSAS
CREATE PROC añadir_ventas @idventa int, @ID_Cliente int, @ID_Empleado int
AS BEGIN 
	INSERT INTO Ventas_Header (ID_Venta, ID_Cliente, ID_Empleado, Fecha, Hora) VALUES (@idventa, @ID_Cliente, @ID_Empleado, GETDATE(), cast(getdate() as time));
END

exec añadir_ventas 10, 2, 4

CREATE PROC añadir_ventas_detalle @ID_Venta int, @nombre_Producto varchar(50), @Cantidad int, @Precio_Unitario float
AS BEGIN 
	DECLARE @ID_Producto int
	SET @ID_Producto = (SELECT ID_Producto from Productos_Header where Nombre = @nombre_Producto)
	INSERT INTO Ventas_Detalle VALUES (@ID_Venta, @ID_Producto, @Cantidad, @Precio_Unitario);
END

exec añadir_ventas_detalle 10, 'Trapeador' ,1,10

CREATE PROC disminuir_disponibilidad @Nombre_Producto varchar(50), @Cantidad int
AS BEGIN
	DECLARE @ID_Producto int
	SET @ID_Producto = (SELECT ID_Producto from Productos_Header where Nombre = @Nombre_Producto)
	UPDATE Productos_Header SET Disponibilidad -= @Cantidad WHERE ID_Producto = @ID_Producto
END

EXEC disminuir_disponibilidad 'Trapeador', 1


CREATE PROC agregar_empleado @id_empleado int, @Nombre varchar(100), @Posicion varchar(20), @telefono varchar(15)
AS BEGIN
	IF @id_empleado IS NULL --Si id_empleado es null entonces es un nuevo empleado a insertar
	BEGIN
		DECLARE @aux int 
		SET @aux =(select MAX(ID_Empleado) from Empleados)
		INSERT INTO Empleados VALUES (@aux+1, @Nombre, @Posicion, @telefono)
	END ELSE BEGIN --Si no, entonces se quiere modificar el empleado existente.
		UPDATE Empleados SET Nombre = @Nombre, Posicion = @Posicion, Telefono = @telefono WHERE ID_Empleado = @id_empleado
	END
END

CREATE PROC agregar_usuario @id_empleado int, @rol varchar (50)
AS BEGIN

	DECLARE @id_rol int --Obteniendo el id_rol a partir del nombre del rol
	SET @id_rol = (SELECT ID_Rol from Roles WHERE Descripcion = @rol)

	IF @id_empleado not in (SELECT ID_Empleado FROM Usuarios) --Si el id empleado no está en Usuarios, entonces ese empleado no tiene usuario en el sistema.
		BEGIN
			INSERT INTO Usuarios VALUES (@id_empleado, @id_rol) --Añadimos a usuarios
	END ELSE BEGIN
			UPDATE Usuarios SET ID_Rol = @id_rol WHERE ID_Empleado = @id_empleado	--Si queremos actualizar el rol (tabla usuarios)
	END
END

exec agregar_usuario 5, 'GERENTE'

CREATE VIEW pedidos_vista AS --Vista que trae los datos que vamos a mostrar en la pestaña "Pedidos"
	SELECT ph.ID_Pedido, 
			e.Nombre AS Nombre_Empleado,
			p.Nombre AS Nombre_Proveedor,
			p.Telefono,
			m.Descripcion,
			SUM(pd.Cantidad*pd.Costo_Mayoreo) AS Total_Orden,
			ph.Fecha_Pedido, ph.Fecha_Entregado
	FROM Pedidos_Header ph
	INNER JOIN Proveedores p ON p.ID_Proveedor = ph.ID_Proveedor
	INNER JOIN Empleados e ON e.ID_Empleado = ph.ID_Empleado
	INNER JOIN Marcas m ON p.ID_Marca = m.ID_Marca
	INNER JOIN Pedidos_Detalle pd ON pd.ID_Pedido = ph.ID_Pedido
	GROUP BY ph.ID_Pedido, p.Nombre, p.Telefono, e.Nombre, m.Descripcion, ph.Fecha_Entregado, ph.Fecha_Pedido


CREATE PROC aumentar_disponibilidad @ID_Producto int, @cantidad int --Aumenta la disponibilidad de todos los productos en una orden dada
AS BEGIN
	UPDATE Productos_Header SET Disponibilidad += @cantidad WHERE ID_Producto = @ID_Producto
END

EXEC aumentar_disponibilidad 1,20

CREATE PROC nuevo_pedido_header @ID_Pedido int, @ID_Proveedor int, @ID_Empleado int --Agrega un nuevo pedido a proveedor a pedidos_header
AS BEGIN
	INSERT INTO Pedidos_Header VALUES (@ID_Pedido, @ID_Proveedor, @ID_Empleado, GETDATE(), NULL)
END


CREATE PROC nuevo_pedido_detalle @ID_Pedido int, @ID_Producto int, @Cantidad int, @Costo_Mayoreo float   --Agrega todos los productos pedidos a pedidos_detalle
AS BEGIN
	INSERT INTO Pedidos_Detalle VALUES (@ID_Pedido, @ID_Producto, @Cantidad, @Costo_Mayoreo)
END

create FUNCTION ver_ventas (@id_venta int) RETURNS TABLE	--Regresa una tabla la información que se muestra de una venta dada
AS RETURN
	SELECT vd.ID_Producto, 
			p.Nombre, 
			vd.Cantidad,
			vd.Precio_Unitario AS Precio, 
			e.Nombre AS Empleado, 
			c.Nombre AS Cliente, 
			vh.Fecha, 
			c.Telefono AS Telefono_Cliente,
			e.Telefono AS Telefono_Empleado
	FROM Ventas_Detalle vd
	INNER JOIN Ventas_Header vh ON vh.ID_Venta = vd.ID_Venta
	INNER JOIN Empleados e ON e.ID_Empleado = vh.ID_Empleado
	INNER JOIN Productos_Header p ON p.ID_Producto = vd.ID_Producto
	INNER JOIN Clientes c ON c.ID_Cliente = vh.ID_Cliente
	WHERE vh.ID_Venta = @id_venta

SELECT * from dbo.ver_ventas (2)

CREATE FUNCTION calcular_venta (@id_venta int) RETURNS float		 --Calcula el total de la venta
AS BEGIN
	DECLARE @total float
	SET @total = (SELECT SUM(vd.Cantidad*vd.Precio_Unitario) FROM Ventas_Detalle vd WHERE ID_Venta = @id_venta GROUP BY ID_Venta )
	RETURN @total
END

CREATE PROC guardar_clientes @ID_Cliente varchar(10), @nombre varchar(100), @telefono varchar (15)
AS BEGIN
	DECLARE @maxid int
	SET @maxid = (SELECT MAX(ID_Cliente) from Clientes)
	IF @ID_Cliente not in (SELECT ID_Cliente from Clientes)
		BEGIN
			INSERT INTO Clientes VALUES (@maxid+1, @nombre, @telefono )
		END
	ELSE
		BEGIN
			UPDATE Clientes SET Nombre = @nombre, Telefono = @telefono WHERE ID_Cliente = @ID_Cliente
		END	
END

CREATE PROC guardar_proveedores @ID_Proveedor int, @nombre varchar(100), @Marca varchar(100), @Telefono varchar(100)
AS BEGIN
	DECLARE @id_marca int  --Obteniendo el id de marca a partir del nombre de la marca
	SET @id_marca = (SELECT ID_Marca from Marcas WHERE Descripcion = @Marca)
		IF @ID_Proveedor NOT IN (SELECT ID_Proveedor from Proveedores)	--Nuevo Proveedor
			BEGIN	
				DECLARE @maxid int	--Obteniendo el id de proveedor mas grande para asignarselos al nuevo
				SET @maxid = (SELECT MAX(ID_Proveedor) from Proveedores)
				INSERT INTO Proveedores VALUES (@maxid+1, @nombre, @id_marca, @Telefono)
			END ELSE BEGIN --Modificando proveedor existente
				UPDATE Proveedores SET Nombre = @nombre, Telefono = @Telefono , ID_Marca = @id_marca WHERE ID_Proveedor = @ID_Proveedor
			END
END

EXEC guardar_proveedores 8, 'xd', 'Generica', '145678761'

select ID_Venta, dbo.calcular_venta(ID_Venta) from Ventas_Header WHERE Fecha = cast(getdate() as date)


CREATE VIEW empleados_ventas AS --Vista que almacena todas las ventas de los empleados
				SELECT E.Nombre,ROUND(SUM(Cantidad*Precio_Unitario),2) AS total_empleado FROM Ventas_Detalle vd
				INNER JOIN Ventas_Header vh ON vh.ID_Venta = vd.ID_Venta
				INNER JOIN Empleados e ON vh.ID_Empleado = e.ID_Empleado
				GROUP BY e.ID_Empleado, e.Nombre


CREATE PROC create_view_empleado_masventas @tiempo varchar(10)  --Procedimiento que modifica dicha vista
AS BEGIN
	if @tiempo = 'Año'
		BEGIN	
			EXEC('ALTER VIEW empleados_ventas AS 
				SELECT E.Nombre,ROUND(SUM(Cantidad*Precio_Unitario),2) AS total_empleado FROM Ventas_Detalle vd
				INNER JOIN Ventas_Header vh ON vh.ID_Venta = vd.ID_Venta
				INNER JOIN Empleados e ON vh.ID_Empleado = e.ID_Empleado
				WHERE YEAR(Fecha) = YEAR(getdate())
				GROUP BY e.ID_Empleado, e.Nombre')
		END

	if @tiempo = 'Mes'
		BEGIN
			EXEC('ALTER VIEW empleados_ventas AS 
				SELECT E.Nombre,ROUND(SUM(Cantidad*Precio_Unitario),2) AS total_empleado FROM Ventas_Detalle vd
				INNER JOIN Ventas_Header vh ON vh.ID_Venta = vd.ID_Venta
				INNER JOIN Empleados e ON vh.ID_Empleado = e.ID_Empleado
				WHERE Month(Fecha) = Month(getdate())
				GROUP BY e.ID_Empleado, e.Nombre')
		END

	if @tiempo = 'Día'
		BEGIN
			EXEC('ALTER VIEW empleados_ventas AS 
				SELECT E.Nombre,ROUND(SUM(Cantidad*Precio_Unitario),2) AS total_empleado FROM Ventas_Detalle vd
				INNER JOIN Ventas_Header vh ON vh.ID_Venta = vd.ID_Venta
				INNER JOIN Empleados e ON vh.ID_Empleado = e.ID_Empleado
				WHERE DAY(Fecha) = DAY(getdate())
				GROUP BY e.ID_Empleado, e.Nombre')
		END
END

exec create_view_empleado_masventas 'Mes'
select TOP 1 * from temp ORDER BY total_empleado DESC


--Lo mismo que arriba pero con los clientes

CREATE VIEW clientes_compras AS --Vista que almacena todas las compras de los clientes
				SELECT c.Nombre,ROUND(SUM(Cantidad*Precio_Unitario),2) AS total_cliente FROM Ventas_Detalle vd
				INNER JOIN Ventas_Header vh ON vh.ID_Venta = vd.ID_Venta
				INNER JOIN Clientes c ON vh.ID_Cliente = c.ID_Cliente
				GROUP BY  c.Nombre, c.ID_Cliente


CREATE PROC create_view_clientes_mascompras @tiempo varchar(10)  --Procedimiento que modifica dicha vista
AS BEGIN
	if @tiempo = 'Año'
		BEGIN	
			EXEC('ALTER VIEW clientes_compras AS
				SELECT c.Nombre,ROUND(SUM(Cantidad*Precio_Unitario),2) AS total_cliente FROM Ventas_Detalle vd
				INNER JOIN Ventas_Header vh ON vh.ID_Venta = vd.ID_Venta
				INNER JOIN Clientes c ON vh.ID_Cliente = c.ID_Cliente
				WHERE YEAR(Fecha) = YEAR(getdate())
				GROUP BY  c.Nombre, c.ID_Cliente')

		END

	if @tiempo = 'Mes'
		BEGIN
			EXEC('ALTER VIEW clientes_compras AS
				SELECT c.Nombre,ROUND(SUM(Cantidad*Precio_Unitario),2) AS total_cliente FROM Ventas_Detalle vd
				INNER JOIN Ventas_Header vh ON vh.ID_Venta = vd.ID_Venta
				INNER JOIN Clientes c ON vh.ID_Cliente = c.ID_Cliente
				WHERE Month(Fecha) = Month(getdate())
				GROUP BY  c.Nombre, c.ID_Cliente')
		END

	if @tiempo = 'Día'
		BEGIN
			EXEC('ALTER VIEW clientes_compras AS
				SELECT c.Nombre,ROUND(SUM(Cantidad*Precio_Unitario),2) AS total_cliente FROM Ventas_Detalle vd
				INNER JOIN Ventas_Header vh ON vh.ID_Venta = vd.ID_Venta
				INNER JOIN Clientes c ON vh.ID_Cliente = c.ID_Cliente
				WHERE DAY(Fecha) = DAY(getdate())
				GROUP BY  c.Nombre, c.ID_Cliente')
		END
END

exec create_view_clientes_mascompras 'Día'
select TOP 1 * from clientes_compras ORDER BY total_cliente DESC

SELECT TOP 1 p.Nombre, pv.Nombre ,SUM(vd.Cantidad) FROM Ventas_Detalle vd
INNER JOIN Productos_Header p ON p.ID_Producto = vd.ID_Producto
INNER JOIN Marcas m ON m.ID_Marca = p.ID_Marca
INNER JOIN Proveedores pv ON p.ID_Proveedor = pv.ID_Proveedor
GROUP BY p.ID_Producto, p.Nombre, pv.Nombre
ORDER BY SUM(vd.Cantidad) DESC

CREATE PROC get_producto_vendido @tiempo varchar(10)
AS BEGIN
	if @tiempo = 'Semana'
		BEGIN 
			SELECT TOP 1 p.Nombre, pv.Nombre ,SUM(vd.Cantidad) FROM Ventas_Detalle vd
			INNER JOIN Ventas_Header vh ON vd.ID_Venta = vh.ID_Venta
			INNER JOIN Productos_Header p ON p.ID_Producto = vd.ID_Producto
			INNER JOIN Marcas m ON m.ID_Marca = p.ID_Marca
			INNER JOIN Proveedores pv ON p.ID_Proveedor = pv.ID_Proveedor
			WHERE vh.Fecha >= GETDATE()-7
			GROUP BY p.ID_Producto, p.Nombre, pv.Nombre
			ORDER BY SUM(vd.Cantidad) DESC
		END
	if @tiempo = 'Todo'
		BEGIN
			SELECT TOP 1 p.Nombre, pv.Nombre ,SUM(vd.Cantidad) FROM Ventas_Detalle vd
			INNER JOIN Productos_Header p ON p.ID_Producto = vd.ID_Producto
			INNER JOIN Marcas m ON m.ID_Marca = p.ID_Marca
			INNER JOIN Proveedores pv ON p.ID_Proveedor = pv.ID_Proveedor
			GROUP BY p.ID_Producto, p.Nombre, pv.Nombre
			ORDER BY SUM(vd.Cantidad) DESC
		END
	if @tiempo = 'Día'
		BEGIN
			SELECT TOP 1 p.Nombre, pv.Nombre ,SUM(vd.Cantidad) FROM Ventas_Detalle vd
			INNER JOIN Ventas_Header vh ON vd.ID_Venta = vh.ID_Venta
			INNER JOIN Productos_Header p ON p.ID_Producto = vd.ID_Producto
			INNER JOIN Marcas m ON m.ID_Marca = p.ID_Marca
			INNER JOIN Proveedores pv ON p.ID_Proveedor = pv.ID_Proveedor
			WHERE vh.Fecha = cast(GETDATE() as date)
			GROUP BY p.ID_Producto, p.Nombre, pv.Nombre
			ORDER BY SUM(vd.Cantidad) DESC
		END
END

EXEC get_producto_vendido 'Semana'

CREATE PROC eliminar_producto @id int
AS BEGIN
	IF @id NOT IN (SELECT ID_Producto FROM Productos_Med) 
		BEGIN
			DELETE FROM Productos_Header WHERE ID_Producto = @id
		END ELSE BEGIN
			DELETE FROM Productos_Med WHERE ID_Producto = @id
			DELETE FROM Productos_Header WHERE ID_Producto = @id
		END
END

EXEC eliminar_producto 6

CREATE PROC guardar_categoria @id varchar(3), @desc varchar(50)
AS BEGIN
	IF @id in (select ID_Categoria from Categorias_Prod)
	BEGIN
		UPDATE Categorias_Prod SET Descripcion = @desc WHERE ID_Categoria = @id
	END ELSE BEGIN
		DECLARE @maxid int
		SET @maxid = (SELECT MAX(ID_Categoria) FROM Categorias_Prod)
		INSERT INTO Categorias_Prod VALUES (@maxid+1, @desc)
	END
END

CREATE PROC guardar_marca @id varchar(3), @desc varchar(50)
AS BEGIN
	IF @id in (select ID_Marca from Marcas)
	BEGIN
		UPDATE Marcas SET Descripcion = @desc WHERE ID_Marca = @id
	END ELSE BEGIN
		DECLARE @maxid int
		SET @maxid = (SELECT MAX(ID_Marca) FROM Marcas)
		INSERT INTO Marcas VALUES (@maxid+1, @desc)
	END
END

CREATE PROC guardar_presentacion @id varchar(3), @desc varchar(50)
AS BEGIN
	IF @id in (select ID_Presentacion from Presentaciones)
	BEGIN
		UPDATE Presentaciones SET Descripcion = @desc WHERE ID_Presentacion = @id
	END ELSE BEGIN
		DECLARE @maxid int
		INSERT INTO Presentaciones VALUES (@maxid+1, @desc)
	END
END

--Procedimiento que guarda un nuevo producto o modifica en la tabla productos, si el producto es medicina entonces guarda esos atributos también en la otra tabla.
CREATE PROC guardar_producto @id varchar(3), @nombre varchar(50), @precio float, @categoria varchar(50),
@marca varchar(50), @proveedor varchar(50), @disponibilidad int, @ingrediente varchar(100), @presentacion varchar(50),
@caducidad date, @cantidadxu varchar(20), @pesoxu varchar(20)

AS BEGIN

	--Asumiremos que todos los datos están validados, obtendremos los id necesarios dados su descripcion
	DECLARE @idcat int Set @idcat = (SELECT ID_Categoria FROM Categorias_Prod WHERE Descripcion = @categoria)
	DECLARE @idmarca int Set @idmarca = (SELECT ID_Marca FROM Marcas WHERE Descripcion = @marca)
	DECLARE @idprov int SET @idprov = (SELECT ID_Proveedor FROM Proveedores WHERE Nombre = @proveedor)
	DECLARE @idpres int SET @idpres = (SELECT ID_Presentacion FROM Presentaciones WHERE Descripcion = @presentacion)

	IF @id IN (SELECT ID_Producto FROM Productos_Header) --Si el producto está en la db
		BEGIN --Actualizamos tabla con los nuevos datos

			DECLARE @oldcat varchar(50)
			SET @oldcat = (SELECT c.Descripcion FROM Productos_Header ph INNER JOIN Categorias_Prod c ON c.ID_Categoria = ph.ID_Categoria WHERE ID_Producto = @id )
			UPDATE Productos_Header SET Nombre = @nombre, Precio_unitario = @precio, Disponibilidad = @disponibilidad, 
			ID_Marca = @idmarca, ID_Categoria = @idcat, ID_Proveedor = @idprov WHERE ID_Producto = @id

			IF @categoria = 'Medicina' --Si el producto es un medicamento, entonces actualizamos sus respectivos datos en la otra tabla
				BEGIN
					UPDATE Productos_Med SET Ingrediente = @ingrediente, ID_Presentacion = @idpres, Caducidad = @caducidad,
					CantidadxU = @cantidadxu, PesoxU = @pesoxu WHERE ID_Producto = @id
				END

			--El siguiente if hace que, si tenemos un producto que antes era un medicamento y se modifica para que ya no lo sea,
			
			--Entonces eliminar su entrada en productos med
			IF @oldcat = 'Medicina' AND NOT @categoria = 'Medicina'
				BEGIN
					DELETE FROM Productos_Med WHERE ID_Producto = @id
				END

			--Lo mismo tenemos acá, si tenemos un producto que va a ser medicamento, entonces se agrega a la tabla productos_med
			IF NOT @oldcat = 'Medicina' AND @categoria = 'Medicina'
				BEGIN
					INSERT INTO Productos_Med VALUES (@id, @ingrediente, @idpres, @caducidad, @cantidadxu, @pesoxu);
				END

		END
		ELSE --Si el id no está en la db entonces se entiende que es un nuevo producto a insertar.

		BEGIN --Vamos a obtener el id más alto para que el nuevo sea uno mayor que ese.

			DECLARE @maxid int SET @maxid = (SELECT MAX(ID_Producto) FROM Productos_Header)
			INSERT INTO Productos_Header VALUES (@maxid+1, @nombre, @precio, @idprov, @idcat, @idmarca, @disponibilidad)

			--Si el nuevo producto es una medicina entonces se inserta en la tabla de productos.
			IF @categoria = 'Medicina' 
				BEGIN
					INSERT INTO Productos_Med VALUES (@maxid+1, @ingrediente, @idpres, @caducidad, @cantidadxu, @pesoxu)
				END
		END
END	

CREATE PROC daily_ventas_productos 
AS BEGIN
	SELECT vd.ID_Producto, SUM(vd.Cantidad) AS [Cantidad Vendida], ROUND(SUM(vd.Precio_Unitario * vd.Cantidad),2) AS [Total Producto], ph.Nombre FROM Ventas_Detalle vd
	INNER JOIN Ventas_Header vh ON vd.ID_Venta = vh.ID_Venta
	INNER JOIN Productos_Header ph ON ph.ID_Producto = vd.ID_Producto
	WHERE vh.Fecha = cast(GETDATE() as date)
	GROUP BY vd.ID_Producto, ph.Nombre
	ORDER BY [Cantidad Vendida] DESC
END

CREATE FUNCTION regresar_ticket (@id_venta int) RETURNS TABLE
AS RETURN
	(SELECT vd.Cantidad,
		vd.Precio_Unitario,
		(vd.Cantidad*vd.Precio_Unitario) AS Subtotal,
		ph.Nombre
		FROM Ventas_Detalle vd
	INNER JOIN Ventas_Header vh ON vd.ID_Venta = vh.ID_Venta
	INNER JOIN Productos_Header ph ON ph.ID_Producto = vd.ID_Producto
	WHERE vh.Fecha = cast(GETDATE() as date) AND vh.ID_Venta = @id_venta)

CREATE PROC daily_ventas AS BEGIN
	SELECT vh.ID_Venta, format(cast(vh.Hora as smalldatetime), 't'), c.Nombre, e.Nombre  FROM Ventas_Header vh
	INNER JOIN Clientes c ON c.ID_Cliente = vh.ID_Cliente
	INNER JOIN Empleados e ON e.ID_Empleado = vh.ID_Cliente
	WHERE vh.Fecha = cast(GETDATE() as date)
END

select * from Marcas
select * from Presentaciones
select * from Categorias_Prod
SELECT * FROM Proveedores
select * from Pedidos_Header
select * from Pedidos_Detalle
select * from Pedidos_vista order by Fecha_pedido
select * from sys.database_principals
select * from sys.database_role_members
select * from Usuarios	
select * from Roles
select * FROM Productos_Med
select * from Productos_Header
select * from Ventas_Header
select * from Ventas_Detalle
select * from Empleados
select * from Clientes


