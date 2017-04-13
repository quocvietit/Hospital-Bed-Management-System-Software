create table Department
(
	DepartmentID nvarchar(30) not null primary key,
	DepartmentName nvarchar(100) not null,
)

create table Room
(
	RoomID nvarchar(30) not null primary key,
	RoomName nvarchar(100) not null,
	Price float not null,
	DepartmentID nvarchar(30) not null
)

create table Bed
(
	BedID nvarchar(30) not null primary key,
	BedName nvarchar(100) not null,
	Price float not null,
	Type nvarchar(30) not null,
	Status nvarchar(30) not null,
	RoomID nvarchar(30) not null
)

create table Patient
(
	PatientID nvarchar(30) not null primary key,
	PatientName nvarchar(100) not null,
	DayOfBirth DateTime not null,
	IdentifyNumber nvarchar(30) not null,
	BedID nvarchar(30) not null,
	RoomID nvarchar(30) not null
)

ALTER TABLE Room  WITH CHECK ADD FOREIGN KEY(DepartmentID)
REFERENCES Department (DepartmentID)

ALTER TABLE Bed  WITH CHECK ADD FOREIGN KEY(RoomID)
REFERENCES Room (RoomID)

ALTER TABLE Patient  WITH CHECK ADD FOREIGN KEY(BedID)
REFERENCES Bed (BedID)

ALTER TABLE Patient  WITH CHECK ADD FOREIGN KEY(RoomID)
REFERENCES Room (RoomID)
