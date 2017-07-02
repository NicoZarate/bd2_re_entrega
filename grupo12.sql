-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 02-07-2017 a las 21:59:31
-- Versión del servidor: 10.1.13-MariaDB
-- Versión de PHP: 5.6.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `grupo12`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `calificacion`
--

CREATE TABLE `calificacion` (
  `id_calificacion` bigint(20) NOT NULL,
  `puntaje` int(11) DEFAULT NULL,
  `comentario` varchar(255) DEFAULT NULL,
  `id_pasajero` bigint(20) DEFAULT NULL,
  `id_viaje` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `calificacion`
--

INSERT INTO `calificacion` (`id_calificacion`, `puntaje`, `comentario`, `id_pasajero`, `id_viaje`) VALUES
(20, 4, 'buen viaje', 4, 14),
(21, 5, 'excelente viaje', 5, 14),
(22, 4, 'bien', 6, 14),
(23, 5, 'bien', 9, 17),
(24, 5, 'bien', 6, 17),
(25, 2, 'bien', 4, 18),
(26, 3, 'bien', 6, 18),
(27, 4, 'bien', 5, 19),
(28, 2, 'bien', 4, 20),
(29, 5, 'bien', 9, 21),
(30, 4, 'bien', 6, 21);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `conductor`
--

CREATE TABLE `conductor` (
  `id_usuario` bigint(20) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `contrasenia` varchar(255) DEFAULT NULL,
  `f_ingreso` datetime DEFAULT NULL,
  `id_muber` bigint(20) DEFAULT NULL,
  `f_licencia` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `conductor`
--

INSERT INTO `conductor` (`id_usuario`, `nombre`, `contrasenia`, `f_ingreso`, `id_muber`, `f_licencia`) VALUES
(1, 'Juan', '1234', '2017-07-02 16:56:46', 4, '2020-03-20 00:00:00'),
(2, 'Pablo', '1234', '2017-07-02 16:56:46', 4, '2020-03-20 00:00:00'),
(3, 'Roberto', '1234', '2017-07-02 16:56:46', 4, '2020-03-20 00:00:00'),
(7, 'Patricio', '1234', '2017-07-02 16:56:46', 4, '2020-03-20 00:00:00'),
(8, 'Carla', '1234', '2017-07-02 16:56:46', 4, '2020-03-20 00:00:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hibernate_unique_key`
--

CREATE TABLE `hibernate_unique_key` (
  `next_hi` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `hibernate_unique_key`
--

INSERT INTO `hibernate_unique_key` (`next_hi`) VALUES
(1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `muber`
--

CREATE TABLE `muber` (
  `id_muber` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `muber`
--

INSERT INTO `muber` (`id_muber`) VALUES
(4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pasajero`
--

CREATE TABLE `pasajero` (
  `id_usuario` bigint(20) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `contrasenia` varchar(255) DEFAULT NULL,
  `f_ingreso` datetime DEFAULT NULL,
  `id_muber` bigint(20) DEFAULT NULL,
  `credito` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `pasajero`
--

INSERT INTO `pasajero` (`id_usuario`, `nombre`, `contrasenia`, `f_ingreso`, `id_muber`, `credito`) VALUES
(4, 'Alicia', 'a', '2017-07-02 16:56:46', 4, 1050),
(5, 'German', 'g', '2017-07-02 16:56:46', 4, 1100),
(6, 'Margarita', 'm', '2017-07-02 16:56:46', 4, 3350),
(9, 'Hugo', 'h', '2017-07-02 16:56:46', 4, 500);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pasajero_viaje`
--

CREATE TABLE `pasajero_viaje` (
  `id_pasajero` bigint(20) NOT NULL,
  `id_viaje` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `pasajero_viaje`
--

INSERT INTO `pasajero_viaje` (`id_pasajero`, `id_viaje`) VALUES
(4, 14),
(5, 14),
(6, 14),
(6, 17),
(9, 17),
(4, 18),
(6, 18),
(5, 19),
(4, 20),
(6, 21),
(9, 21);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `viaje`
--

CREATE TABLE `viaje` (
  `id_viaje` bigint(20) NOT NULL,
  `max_pasajeros` int(11) DEFAULT NULL,
  `finalizado` bit(1) DEFAULT NULL,
  `destino` varchar(255) DEFAULT NULL,
  `origen` varchar(255) DEFAULT NULL,
  `costo` float DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  `id_conductor` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `viaje`
--

INSERT INTO `viaje` (`id_viaje`, `max_pasajeros`, `finalizado`, `destino`, `origen`, `costo`, `fecha`, `id_conductor`) VALUES
(14, 4, b'1', 'Tres Arroyos', 'La Plata', 900, '2017-07-02 16:56:46', 3),
(15, 1, b'0', 'La Plata', 'Moron', 12900, '2017-07-02 16:56:46', 3),
(16, 4, b'0', 'Buenos Aires', 'La Plata', 500, '2017-07-02 16:56:46', 3),
(17, 2, b'1', 'Cordoba', 'Chascomus', 100, '2017-07-02 16:56:49', 8),
(18, 2, b'1', 'Cordoba', 'Rosario', 100, '2017-07-02 16:56:50', 7),
(19, 2, b'1', 'Cordoba', 'La Plata', 100, '2017-07-02 16:56:50', 1),
(20, 2, b'1', 'Cordoba', 'Moron', 100, '2017-07-02 16:56:50', 2),
(21, 2, b'1', 'Cordoba', 'Mar del Plata', 3500, '2017-07-02 16:56:54', 3);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `calificacion`
--
ALTER TABLE `calificacion`
  ADD PRIMARY KEY (`id_calificacion`),
  ADD KEY `FKafa4jqntqfcnvcnmnwow5i75d` (`id_pasajero`),
  ADD KEY `FKqh56hs0ewvfggao929pc70u8y` (`id_viaje`);

--
-- Indices de la tabla `conductor`
--
ALTER TABLE `conductor`
  ADD PRIMARY KEY (`id_usuario`),
  ADD KEY `FK50auotqlmspfldphr0x6ntdjm` (`id_muber`);

--
-- Indices de la tabla `muber`
--
ALTER TABLE `muber`
  ADD PRIMARY KEY (`id_muber`);

--
-- Indices de la tabla `pasajero`
--
ALTER TABLE `pasajero`
  ADD PRIMARY KEY (`id_usuario`),
  ADD KEY `FKh66oexexe1c7jcmec99aex3ca` (`id_muber`);

--
-- Indices de la tabla `pasajero_viaje`
--
ALTER TABLE `pasajero_viaje`
  ADD PRIMARY KEY (`id_viaje`,`id_pasajero`),
  ADD KEY `FKrbm8pbxml84faprxpyof4jlue` (`id_pasajero`);

--
-- Indices de la tabla `viaje`
--
ALTER TABLE `viaje`
  ADD PRIMARY KEY (`id_viaje`),
  ADD KEY `FKbmy1jnpv64us5k48vhijlef0a` (`id_conductor`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `calificacion`
--
ALTER TABLE `calificacion`
  MODIFY `id_calificacion` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;
--
-- AUTO_INCREMENT de la tabla `muber`
--
ALTER TABLE `muber`
  MODIFY `id_muber` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `viaje`
--
ALTER TABLE `viaje`
  MODIFY `id_viaje` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `calificacion`
--
ALTER TABLE `calificacion`
  ADD CONSTRAINT `FKafa4jqntqfcnvcnmnwow5i75d` FOREIGN KEY (`id_pasajero`) REFERENCES `pasajero` (`id_usuario`),
  ADD CONSTRAINT `FKqh56hs0ewvfggao929pc70u8y` FOREIGN KEY (`id_viaje`) REFERENCES `viaje` (`id_viaje`);

--
-- Filtros para la tabla `conductor`
--
ALTER TABLE `conductor`
  ADD CONSTRAINT `FK50auotqlmspfldphr0x6ntdjm` FOREIGN KEY (`id_muber`) REFERENCES `muber` (`id_muber`);

--
-- Filtros para la tabla `pasajero`
--
ALTER TABLE `pasajero`
  ADD CONSTRAINT `FKh66oexexe1c7jcmec99aex3ca` FOREIGN KEY (`id_muber`) REFERENCES `muber` (`id_muber`);

--
-- Filtros para la tabla `pasajero_viaje`
--
ALTER TABLE `pasajero_viaje`
  ADD CONSTRAINT `FK6hufambyxo6btcf5vkbj9syc6` FOREIGN KEY (`id_viaje`) REFERENCES `viaje` (`id_viaje`),
  ADD CONSTRAINT `FKrbm8pbxml84faprxpyof4jlue` FOREIGN KEY (`id_pasajero`) REFERENCES `pasajero` (`id_usuario`);

--
-- Filtros para la tabla `viaje`
--
ALTER TABLE `viaje`
  ADD CONSTRAINT `FKbmy1jnpv64us5k48vhijlef0a` FOREIGN KEY (`id_conductor`) REFERENCES `conductor` (`id_usuario`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
