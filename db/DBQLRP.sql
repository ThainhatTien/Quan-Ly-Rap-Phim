USE [master]
GO
/****** Object:  Database [QuanLyRapPhim]    Script Date: 13/12/2023 5:18:10 CH ******/
CREATE DATABASE [QuanLyRapPhim]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'QuanLyRapPhim', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.TIEN\MSSQL\DATA\QuanLyRapPhim.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'QuanLyRapPhim_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.TIEN\MSSQL\DATA\QuanLyRapPhim_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [QuanLyRapPhim] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QuanLyRapPhim].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QuanLyRapPhim] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QuanLyRapPhim] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QuanLyRapPhim] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QuanLyRapPhim] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QuanLyRapPhim] SET ARITHABORT OFF 
GO
ALTER DATABASE [QuanLyRapPhim] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [QuanLyRapPhim] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QuanLyRapPhim] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QuanLyRapPhim] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QuanLyRapPhim] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QuanLyRapPhim] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QuanLyRapPhim] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QuanLyRapPhim] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QuanLyRapPhim] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QuanLyRapPhim] SET  ENABLE_BROKER 
GO
ALTER DATABASE [QuanLyRapPhim] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QuanLyRapPhim] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QuanLyRapPhim] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QuanLyRapPhim] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QuanLyRapPhim] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QuanLyRapPhim] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QuanLyRapPhim] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QuanLyRapPhim] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [QuanLyRapPhim] SET  MULTI_USER 
GO
ALTER DATABASE [QuanLyRapPhim] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QuanLyRapPhim] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QuanLyRapPhim] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QuanLyRapPhim] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [QuanLyRapPhim] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [QuanLyRapPhim] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [QuanLyRapPhim] SET QUERY_STORE = ON
GO
ALTER DATABASE [QuanLyRapPhim] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [QuanLyRapPhim]
GO
/****** Object:  UserDefinedFunction [dbo].[SeachMaPhim]    Script Date: 13/12/2023 5:18:10 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE FUNCTION [dbo].[SeachMaPhim](@maPhim nvarchar(50))
RETURNS @bang TABLE
(
    MaLichChieu nvarchar(50),
	MaPhong nvarchar(50),
	GioChieu date,
	NgayChieu nvarchar(50) 
)
AS
BEGIN
    INSERT INTO @bang
    select MaLichChieu,MaPhong,GioChieu,NgayChieu 
	from LichChieu join Phim on LichChieu.MaPhim = Phim.MaPhim 
    where Phim.MaPhim = @maPhim
    RETURN
END
GO
/****** Object:  Table [dbo].[LoaiPhim]    Script Date: 13/12/2023 5:18:10 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoaiPhim](
	[MaLoaiPhim] [varchar](50) NOT NULL,
	[TenLoaiPhim] [varchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaLoaiPhim] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Phim]    Script Date: 13/12/2023 5:18:10 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Phim](
	[MaPhim] [varchar](50) NOT NULL,
	[TenPhim] [varchar](50) NOT NULL,
	[MaLoaiPhim] [varchar](50) NOT NULL,
	[NgayKT] [date] NOT NULL,
	[NgayBD] [date] NOT NULL,
	[HinhAnh] [varchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaPhim] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  UserDefinedFunction [dbo].[fn_DSPhim]    Script Date: 13/12/2023 5:18:10 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create function [dbo].[fn_DSPhim]()
returns table return
select MaPhim,TenPhim,TenLoaiPhim,NgayBD,NgayKT from Phim join LoaiPhim on Phim.MaLoaiPhim = LoaiPhim.MaLoaiPhim
GO
/****** Object:  Table [dbo].[DichVu]    Script Date: 13/12/2023 5:18:10 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DichVu](
	[Ma] [nvarchar](50) NULL,
	[Ten] [nvarchar](100) NULL,
	[Gia] [float] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 13/12/2023 5:18:10 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[TenPhim] [nvarchar](50) NULL,
	[SoGhe] [nvarchar](50) NULL,
	[GiaGhe] [float] NULL,
	[ThucAn] [nvarchar](50) NULL,
	[GiaThucAn] [float] NULL,
	[Tong] [float] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LichChieu]    Script Date: 13/12/2023 5:18:10 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LichChieu](
	[MaLichChieu] [varchar](50) NOT NULL,
	[MaPhim] [varchar](50) NOT NULL,
	[MaPhong] [varchar](50) NOT NULL,
	[GioChieu] [date] NOT NULL,
	[NgayChieu] [varchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaLichChieu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LoaiVe]    Script Date: 13/12/2023 5:18:10 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoaiVe](
	[MaLoaiVe] [varchar](50) NOT NULL,
	[TenLoaiVe] [varchar](50) NOT NULL,
	[GiaVe] [float] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaLoaiVe] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LuongNhanVien]    Script Date: 13/12/2023 5:18:10 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LuongNhanVien](
	[MaNV] [varchar](50) NULL,
	[TenNV] [varchar](50) NULL,
	[Luong] [float] NULL,
	[Thuong] [float] NULL,
	[TongLuong] [float] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 13/12/2023 5:18:10 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[MaNV] [varchar](50) NOT NULL,
	[TenNV] [varchar](50) NOT NULL,
	[MatKhau] [varchar](50) NOT NULL,
	[NgaySinh] [date] NOT NULL,
	[DiaChi] [varchar](50) NOT NULL,
	[SoDT] [varchar](50) NOT NULL,
	[GioiTinh] [varchar](50) NOT NULL,
	[VaiTro] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Phong]    Script Date: 13/12/2023 5:18:10 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Phong](
	[MaPhong] [varchar](50) NOT NULL,
	[SoPhong] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ThanhToan]    Script Date: 13/12/2023 5:18:10 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ThanhToan](
	[TenPhim] [nvarchar](50) NULL,
	[SoGhe] [nvarchar](50) NULL,
	[GiaGhe] [float] NULL,
	[ThucAn] [nvarchar](50) NULL,
	[GiaThucAn] [float] NULL,
	[Tong] [float] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Ve]    Script Date: 13/12/2023 5:18:10 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Ve](
	[MaVe] [varchar](50) NOT NULL,
	[SoGhe] [nvarchar](50) NULL,
	[MaLoaiVe] [varchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaVe] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[DichVu] ([Ma], [Ten], [Gia]) VALUES (N'Combo1', N'Nước ', 50000)
INSERT [dbo].[DichVu] ([Ma], [Ten], [Gia]) VALUES (N'Combo2', N'Nước + Bắp Rang', 100000)
INSERT [dbo].[DichVu] ([Ma], [Ten], [Gia]) VALUES (N'Combo3', N'Nước + Bắp Rang Bơ', 150000)
GO
INSERT [dbo].[LichChieu] ([MaLichChieu], [MaPhim], [MaPhong], [GioChieu], [NgayChieu]) VALUES (N'LC01', N'PH01', N'PG01', CAST(N'1900-01-01' AS Date), N'2023-11-30 00:00:00.0000000')
INSERT [dbo].[LichChieu] ([MaLichChieu], [MaPhim], [MaPhong], [GioChieu], [NgayChieu]) VALUES (N'LC02', N'PH02', N'PG01', CAST(N'1900-01-01' AS Date), N'2023-11-30 00:00:00.0000000')
INSERT [dbo].[LichChieu] ([MaLichChieu], [MaPhim], [MaPhong], [GioChieu], [NgayChieu]) VALUES (N'LC03', N'PH03', N'PG01', CAST(N'1900-01-01' AS Date), N'2023-11-30 00:00:00.0000000')
INSERT [dbo].[LichChieu] ([MaLichChieu], [MaPhim], [MaPhong], [GioChieu], [NgayChieu]) VALUES (N'LC04', N'PH02', N'PG02', CAST(N'1900-01-01' AS Date), N'2023-11-30 00:00:00.0000000')
INSERT [dbo].[LichChieu] ([MaLichChieu], [MaPhim], [MaPhong], [GioChieu], [NgayChieu]) VALUES (N'LC05', N'PH01', N'PG02', CAST(N'1900-01-01' AS Date), N'2023-11-30 00:00:00.0000000')
GO
INSERT [dbo].[LoaiPhim] ([MaLoaiPhim], [TenLoaiPhim]) VALUES (N'LP01', N'Hành Ð?ng')
INSERT [dbo].[LoaiPhim] ([MaLoaiPhim], [TenLoaiPhim]) VALUES (N'LP02', N'Kinh D?')
INSERT [dbo].[LoaiPhim] ([MaLoaiPhim], [TenLoaiPhim]) VALUES (N'LP03', N'Hài ')
INSERT [dbo].[LoaiPhim] ([MaLoaiPhim], [TenLoaiPhim]) VALUES (N'LP04', N'Lãng M?n')
INSERT [dbo].[LoaiPhim] ([MaLoaiPhim], [TenLoaiPhim]) VALUES (N'LP05', N'Trinh Thám')
INSERT [dbo].[LoaiPhim] ([MaLoaiPhim], [TenLoaiPhim]) VALUES (N'LP06', N'Ho?t Hình')
GO
INSERT [dbo].[LoaiVe] ([MaLoaiVe], [TenLoaiVe], [GiaVe]) VALUES (N'LV01', N'Vé Thu?ng', 50000)
INSERT [dbo].[LoaiVe] ([MaLoaiVe], [TenLoaiVe], [GiaVe]) VALUES (N'LV02', N'Vé Vip', 150000)
INSERT [dbo].[LoaiVe] ([MaLoaiVe], [TenLoaiVe], [GiaVe]) VALUES (N'LV03', N'Vé Ðôi', 100000)
GO
INSERT [dbo].[LuongNhanVien] ([MaNV], [TenNV], [Luong], [Thuong], [TongLuong]) VALUES (N'NV01', N'Ti?n', 4, 6, 10)
INSERT [dbo].[LuongNhanVien] ([MaNV], [TenNV], [Luong], [Thuong], [TongLuong]) VALUES (N'NV02', N'T', 5, 5, 10)
INSERT [dbo].[LuongNhanVien] ([MaNV], [TenNV], [Luong], [Thuong], [TongLuong]) VALUES (N'NV03', N'A', 5, 5, 10)
GO
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [MatKhau], [NgaySinh], [DiaChi], [SoDT], [GioiTinh], [VaiTro]) VALUES (N'NV01', N'Ti?n', N'111', CAST(N'2004-11-30' AS Date), N'Bình Ð?nh', N'123456789', N'Nam', N'Qu?n lý')
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [MatKhau], [NgaySinh], [DiaChi], [SoDT], [GioiTinh], [VaiTro]) VALUES (N'NV02', N'T', N'123', CAST(N'2004-11-20' AS Date), N'HCM', N'12345678910', N'N?', N'Nhân viên')
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [MatKhau], [NgaySinh], [DiaChi], [SoDT], [GioiTinh], [VaiTro]) VALUES (N'NV03', N'A', N'1', CAST(N'2004-12-03' AS Date), N'Qu?n 9', N'1235', N'N?', N'Nhân viên')
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [MatKhau], [NgaySinh], [DiaChi], [SoDT], [GioiTinh], [VaiTro]) VALUES (N'NV04', N'D', N'd', CAST(N'2004-11-30' AS Date), N'Qu?n 5', N'444444', N'Nam', N'Nhân viên')
GO
INSERT [dbo].[Phim] ([MaPhim], [TenPhim], [MaLoaiPhim], [NgayKT], [NgayBD], [HinhAnh]) VALUES (N'PH01', N'B? Già', N'LP03', CAST(N'2023-12-30' AS Date), CAST(N'2023-11-30' AS Date), N'BoGia.jpeg')
INSERT [dbo].[Phim] ([MaPhim], [TenPhim], [MaLoaiPhim], [NgayKT], [NgayBD], [HinhAnh]) VALUES (N'PH02', N'L?t M?t', N'LP01', CAST(N'2023-12-30' AS Date), CAST(N'2023-11-30' AS Date), N'Lat Mat.jpg')
INSERT [dbo].[Phim] ([MaPhim], [TenPhim], [MaLoaiPhim], [NgayKT], [NgayBD], [HinhAnh]) VALUES (N'PH03', N'Cô Bé C?u H?a', N'LP04', CAST(N'2023-12-30' AS Date), CAST(N'2023-11-30' AS Date), N'Co Be Cuu Hoa.jpg')
INSERT [dbo].[Phim] ([MaPhim], [TenPhim], [MaLoaiPhim], [NgayKT], [NgayBD], [HinhAnh]) VALUES (N'PH04', N'Oan Hon', N'LP02', CAST(N'2023-12-01' AS Date), CAST(N'2023-12-01' AS Date), N'Oan Hon.jpg')
INSERT [dbo].[Phim] ([MaPhim], [TenPhim], [MaLoaiPhim], [NgayKT], [NgayBD], [HinhAnh]) VALUES (N'PH05', N'Doremon', N'LP06', CAST(N'2024-02-02' AS Date), CAST(N'2024-01-01' AS Date), N'Doraemon.jpg')
GO
INSERT [dbo].[Phong] ([MaPhong], [SoPhong]) VALUES (N'PG01', 1)
INSERT [dbo].[Phong] ([MaPhong], [SoPhong]) VALUES (N'PG02', 2)
INSERT [dbo].[Phong] ([MaPhong], [SoPhong]) VALUES (N'PG03', 3)
INSERT [dbo].[Phong] ([MaPhong], [SoPhong]) VALUES (N'PG04', 4)
GO
INSERT [dbo].[ThanhToan] ([TenPhim], [SoGhe], [GiaGhe], [ThucAn], [GiaThucAn], [Tong]) VALUES (N'Oan Hon', N'C5', 150000, N'Nước ', 50000, 150000)
INSERT [dbo].[ThanhToan] ([TenPhim], [SoGhe], [GiaGhe], [ThucAn], [GiaThucAn], [Tong]) VALUES (N'Oan Hon', N'D8', 150000, N'Nước + Bắp Rang Bơ', 150000, 150000)
INSERT [dbo].[ThanhToan] ([TenPhim], [SoGhe], [GiaGhe], [ThucAn], [GiaThucAn], [Tong]) VALUES (N'Doremon', N'E7', 150000, N'Nước + Bắp Rang', 100000, 150000)
INSERT [dbo].[ThanhToan] ([TenPhim], [SoGhe], [GiaGhe], [ThucAn], [GiaThucAn], [Tong]) VALUES (N'L?t M?t', N'G9', 50000, N'Nước ', 50000, 100000)
INSERT [dbo].[ThanhToan] ([TenPhim], [SoGhe], [GiaGhe], [ThucAn], [GiaThucAn], [Tong]) VALUES (N'Oan Hon', N'C7', 150000, N'Nước + Bắp Rang Bơ', 150000, 300000)
INSERT [dbo].[ThanhToan] ([TenPhim], [SoGhe], [GiaGhe], [ThucAn], [GiaThucAn], [Tong]) VALUES (N'L?t M?t', N'A4', 50000, N'Nước ', 50000, 100000)
GO
INSERT [dbo].[Ve] ([MaVe], [SoGhe], [MaLoaiVe]) VALUES (N'V01', N'C1', N'LV01')
INSERT [dbo].[Ve] ([MaVe], [SoGhe], [MaLoaiVe]) VALUES (N'V02', N'C2', N'LV01')
INSERT [dbo].[Ve] ([MaVe], [SoGhe], [MaLoaiVe]) VALUES (N'V03', N'C3', N'LV02')
INSERT [dbo].[Ve] ([MaVe], [SoGhe], [MaLoaiVe]) VALUES (N'V04', N'C4', N'LV02')
INSERT [dbo].[Ve] ([MaVe], [SoGhe], [MaLoaiVe]) VALUES (N'V05', N'C5', N'LV02')
INSERT [dbo].[Ve] ([MaVe], [SoGhe], [MaLoaiVe]) VALUES (N'V06', N'C6', N'LV02')
INSERT [dbo].[Ve] ([MaVe], [SoGhe], [MaLoaiVe]) VALUES (N'V07', N'C7', N'LV02')
INSERT [dbo].[Ve] ([MaVe], [SoGhe], [MaLoaiVe]) VALUES (N'V08', N'C8', N'LV02')
INSERT [dbo].[Ve] ([MaVe], [SoGhe], [MaLoaiVe]) VALUES (N'V09', N'D3', N'LV02')
INSERT [dbo].[Ve] ([MaVe], [SoGhe], [MaLoaiVe]) VALUES (N'V10', N'D4', N'LV02')
INSERT [dbo].[Ve] ([MaVe], [SoGhe], [MaLoaiVe]) VALUES (N'V11', N'D5', N'LV02')
INSERT [dbo].[Ve] ([MaVe], [SoGhe], [MaLoaiVe]) VALUES (N'V12', N'D6', N'LV02')
INSERT [dbo].[Ve] ([MaVe], [SoGhe], [MaLoaiVe]) VALUES (N'V13', N'D7', N'LV02')
INSERT [dbo].[Ve] ([MaVe], [SoGhe], [MaLoaiVe]) VALUES (N'V14', N'D8', N'LV02')
INSERT [dbo].[Ve] ([MaVe], [SoGhe], [MaLoaiVe]) VALUES (N'V15', N'E3', N'LV02')
INSERT [dbo].[Ve] ([MaVe], [SoGhe], [MaLoaiVe]) VALUES (N'V16', N'E4', N'LV02')
INSERT [dbo].[Ve] ([MaVe], [SoGhe], [MaLoaiVe]) VALUES (N'V17', N'E5', N'LV02')
INSERT [dbo].[Ve] ([MaVe], [SoGhe], [MaLoaiVe]) VALUES (N'V18', N'E6', N'LV02')
INSERT [dbo].[Ve] ([MaVe], [SoGhe], [MaLoaiVe]) VALUES (N'V19', N'E7', N'LV02')
INSERT [dbo].[Ve] ([MaVe], [SoGhe], [MaLoaiVe]) VALUES (N'V20', N'E8', N'LV02')
INSERT [dbo].[Ve] ([MaVe], [SoGhe], [MaLoaiVe]) VALUES (N'V21', N'C9', N'LV01')
INSERT [dbo].[Ve] ([MaVe], [SoGhe], [MaLoaiVe]) VALUES (N'V22', N'C10', N'LV01')
INSERT [dbo].[Ve] ([MaVe], [SoGhe], [MaLoaiVe]) VALUES (N'V23', N'D1', N'LV01')
INSERT [dbo].[Ve] ([MaVe], [SoGhe], [MaLoaiVe]) VALUES (N'V24', N'D2', N'LV01')
INSERT [dbo].[Ve] ([MaVe], [SoGhe], [MaLoaiVe]) VALUES (N'V25', N'D9', N'LV01')
INSERT [dbo].[Ve] ([MaVe], [SoGhe], [MaLoaiVe]) VALUES (N'V26', N'D10', N'LV01')
INSERT [dbo].[Ve] ([MaVe], [SoGhe], [MaLoaiVe]) VALUES (N'V27', N'E1', N'LV01')
INSERT [dbo].[Ve] ([MaVe], [SoGhe], [MaLoaiVe]) VALUES (N'V28', N'E2', N'LV01')
INSERT [dbo].[Ve] ([MaVe], [SoGhe], [MaLoaiVe]) VALUES (N'V29', N'E9', N'LV01')
INSERT [dbo].[Ve] ([MaVe], [SoGhe], [MaLoaiVe]) VALUES (N'V30', N'E10', N'LV01')
INSERT [dbo].[Ve] ([MaVe], [SoGhe], [MaLoaiVe]) VALUES (N'V31', N'A1', N'LV01')
INSERT [dbo].[Ve] ([MaVe], [SoGhe], [MaLoaiVe]) VALUES (N'V32', N'A2', N'LV01')
INSERT [dbo].[Ve] ([MaVe], [SoGhe], [MaLoaiVe]) VALUES (N'V33', N'A3', N'LV01')
INSERT [dbo].[Ve] ([MaVe], [SoGhe], [MaLoaiVe]) VALUES (N'V34', N'A4', N'LV01')
INSERT [dbo].[Ve] ([MaVe], [SoGhe], [MaLoaiVe]) VALUES (N'V35', N'A5', N'LV01')
INSERT [dbo].[Ve] ([MaVe], [SoGhe], [MaLoaiVe]) VALUES (N'V36', N'A6', N'LV01')
INSERT [dbo].[Ve] ([MaVe], [SoGhe], [MaLoaiVe]) VALUES (N'V37', N'A7', N'LV01')
INSERT [dbo].[Ve] ([MaVe], [SoGhe], [MaLoaiVe]) VALUES (N'V38', N'A8', N'LV01')
INSERT [dbo].[Ve] ([MaVe], [SoGhe], [MaLoaiVe]) VALUES (N'V39', N'A9', N'LV01')
INSERT [dbo].[Ve] ([MaVe], [SoGhe], [MaLoaiVe]) VALUES (N'V40', N'A10', N'LV01')
INSERT [dbo].[Ve] ([MaVe], [SoGhe], [MaLoaiVe]) VALUES (N'V41', N'B1', N'LV01')
INSERT [dbo].[Ve] ([MaVe], [SoGhe], [MaLoaiVe]) VALUES (N'V42', N'B2', N'LV01')
INSERT [dbo].[Ve] ([MaVe], [SoGhe], [MaLoaiVe]) VALUES (N'V43', N'B3', N'LV01')
INSERT [dbo].[Ve] ([MaVe], [SoGhe], [MaLoaiVe]) VALUES (N'V44', N'B4', N'LV01')
INSERT [dbo].[Ve] ([MaVe], [SoGhe], [MaLoaiVe]) VALUES (N'V45', N'B5', N'LV01')
INSERT [dbo].[Ve] ([MaVe], [SoGhe], [MaLoaiVe]) VALUES (N'V46', N'B6', N'LV01')
INSERT [dbo].[Ve] ([MaVe], [SoGhe], [MaLoaiVe]) VALUES (N'V47', N'B7', N'LV01')
INSERT [dbo].[Ve] ([MaVe], [SoGhe], [MaLoaiVe]) VALUES (N'V48', N'B8', N'LV01')
INSERT [dbo].[Ve] ([MaVe], [SoGhe], [MaLoaiVe]) VALUES (N'V49', N'B9', N'LV01')
INSERT [dbo].[Ve] ([MaVe], [SoGhe], [MaLoaiVe]) VALUES (N'V50', N'B10', N'LV01')
INSERT [dbo].[Ve] ([MaVe], [SoGhe], [MaLoaiVe]) VALUES (N'V51', N'F1', N'LV01')
INSERT [dbo].[Ve] ([MaVe], [SoGhe], [MaLoaiVe]) VALUES (N'V52', N'F2', N'LV01')
INSERT [dbo].[Ve] ([MaVe], [SoGhe], [MaLoaiVe]) VALUES (N'V53', N'F3', N'LV01')
INSERT [dbo].[Ve] ([MaVe], [SoGhe], [MaLoaiVe]) VALUES (N'V54', N'F4', N'LV01')
INSERT [dbo].[Ve] ([MaVe], [SoGhe], [MaLoaiVe]) VALUES (N'V55', N'F5', N'LV01')
INSERT [dbo].[Ve] ([MaVe], [SoGhe], [MaLoaiVe]) VALUES (N'V56', N'F6', N'LV01')
INSERT [dbo].[Ve] ([MaVe], [SoGhe], [MaLoaiVe]) VALUES (N'V57', N'F7', N'LV01')
INSERT [dbo].[Ve] ([MaVe], [SoGhe], [MaLoaiVe]) VALUES (N'V58', N'F8', N'LV01')
INSERT [dbo].[Ve] ([MaVe], [SoGhe], [MaLoaiVe]) VALUES (N'V59', N'F9', N'LV01')
INSERT [dbo].[Ve] ([MaVe], [SoGhe], [MaLoaiVe]) VALUES (N'V60', N'F10', N'LV01')
INSERT [dbo].[Ve] ([MaVe], [SoGhe], [MaLoaiVe]) VALUES (N'V61', N'G1', N'LV01')
INSERT [dbo].[Ve] ([MaVe], [SoGhe], [MaLoaiVe]) VALUES (N'V62', N'G2', N'LV01')
INSERT [dbo].[Ve] ([MaVe], [SoGhe], [MaLoaiVe]) VALUES (N'V63', N'G3', N'LV01')
INSERT [dbo].[Ve] ([MaVe], [SoGhe], [MaLoaiVe]) VALUES (N'V64', N'G4', N'LV01')
INSERT [dbo].[Ve] ([MaVe], [SoGhe], [MaLoaiVe]) VALUES (N'V65', N'G5', N'LV01')
INSERT [dbo].[Ve] ([MaVe], [SoGhe], [MaLoaiVe]) VALUES (N'V66', N'G6', N'LV01')
INSERT [dbo].[Ve] ([MaVe], [SoGhe], [MaLoaiVe]) VALUES (N'V67', N'G7', N'LV01')
INSERT [dbo].[Ve] ([MaVe], [SoGhe], [MaLoaiVe]) VALUES (N'V68', N'G8', N'LV01')
INSERT [dbo].[Ve] ([MaVe], [SoGhe], [MaLoaiVe]) VALUES (N'V69', N'G9', N'LV01')
INSERT [dbo].[Ve] ([MaVe], [SoGhe], [MaLoaiVe]) VALUES (N'V70', N'G10', N'LV01')
GO
ALTER TABLE [dbo].[LichChieu]  WITH CHECK ADD FOREIGN KEY([MaPhim])
REFERENCES [dbo].[Phim] ([MaPhim])
GO
ALTER TABLE [dbo].[LichChieu]  WITH CHECK ADD FOREIGN KEY([MaPhong])
REFERENCES [dbo].[Phong] ([MaPhong])
GO
ALTER TABLE [dbo].[LuongNhanVien]  WITH CHECK ADD FOREIGN KEY([MaNV])
REFERENCES [dbo].[NhanVien] ([MaNV])
GO
ALTER TABLE [dbo].[Phim]  WITH CHECK ADD FOREIGN KEY([MaLoaiPhim])
REFERENCES [dbo].[LoaiPhim] ([MaLoaiPhim])
GO
ALTER TABLE [dbo].[Ve]  WITH CHECK ADD FOREIGN KEY([MaLoaiVe])
REFERENCES [dbo].[LoaiVe] ([MaLoaiVe])
GO
USE [master]
GO
ALTER DATABASE [QuanLyRapPhim] SET  READ_WRITE 
GO
