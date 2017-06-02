use HospitalBedManagement

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
	DepartmentID nvarchar(30) not null,
	TypeRoomID nvarchar(30) not null
)

create table Bed
(
	BedID nvarchar(30) not null primary key,
	BedName nvarchar(100) not null,
	Price float not null,
	Status nvarchar(30) not null,
	RoomID nvarchar(30) not null,
	TypeBedID nvarchar(30) not null
)

create table Patient
(
	PatientID nvarchar(30) not null primary key,
	PatientName nvarchar(100) not null,
	DayOfBirth nvarchar(10) not null,
	IdentifyNumber nvarchar(30) not null
)

create table BedPatientDetails
(
	BedID nvarchar(30) not null,
	PatientID nvarchar(30) not null,
	Checkin nvarchar(10) not null,
	Checkout nvarchar(10) not null,
	primary key (BedID, PatientID)
)

create table TypeBed
(
	TypeBedID nvarchar(30) not null primary key,
	TypeBedName nvarchar(100) not null,
	QuantityBed int not null
)

create table TypeRoom
(
	TypeRoomID nvarchar(30) not null primary key,
	TypeRoomName nvarchar(100) not null,
)

create table PriceRoom
(
	PriceRoomID nvarchar(30) not null primary key,
	Price float not null,
	TypeRoomID nvarchar(30) not null
)

create table PriceBed
(
	PriceBedID nvarchar(30) not null primary key,
	Price float not null,
	TypeBedID nvarchar(30) not null
)

ALTER TABLE Room  WITH CHECK ADD FOREIGN KEY(DepartmentID)
REFERENCES Department (DepartmentID)

ALTER TABLE Bed  WITH CHECK ADD FOREIGN KEY(RoomID)
REFERENCES Room (RoomID)

ALTER TABLE BedPatientDetails  WITH CHECK ADD FOREIGN KEY(BedID)
REFERENCES Bed (BedID)

ALTER TABLE BedPatientDetails  WITH CHECK ADD FOREIGN KEY(PatientID)
REFERENCES Patient (PatientID)

ALTER TABLE Bed  WITH CHECK ADD FOREIGN KEY(TypeBedID)
REFERENCES TypeBed (TypeBedID)

ALTER TABLE Room  WITH CHECK ADD FOREIGN KEY(TypeRoomID)
REFERENCES TypeRoom (TypeRoomID)

ALTER TABLE PriceBed  WITH CHECK ADD FOREIGN KEY(TypeBedID)
REFERENCES TypeBed (TypeBedID)

ALTER TABLE PriceRoom  WITH CHECK ADD FOREIGN KEY(TypeRoomID)
REFERENCES TypeRoom (TypeRoomID)








