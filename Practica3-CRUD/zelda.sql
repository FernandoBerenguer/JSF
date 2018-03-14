-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-11-2017 a las 14:35:28
-- Versión del servidor: 5.5.27
-- Versión de PHP: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `zelda`
--
CREATE DATABASE `zelda` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `zelda`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `consolas`
--

CREATE TABLE IF NOT EXISTS `consolas` (
  `id_consola` int(11) NOT NULL AUTO_INCREMENT,
  `nombreconsola` varchar(20) NOT NULL,
  PRIMARY KEY (`id_consola`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Volcado de datos para la tabla `consolas`
--

INSERT INTO `consolas` (`id_consola`, `nombreconsola`) VALUES
(1, 'NES'),
(2, 'Nintendo 64'),
(3, 'GameBoy'),
(4, 'Game Cube'),
(5, 'Wii');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `juegos`
--

CREATE TABLE IF NOT EXISTS `juegos` (
  `id_juego` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  PRIMARY KEY (`id_juego`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Volcado de datos para la tabla `juegos`
--

INSERT INTO `juegos` (`id_juego`, `nombre`) VALUES
(1, 'The legend of Zelda'),
(2, 'A Link to the past'),
(3, 'Link''s Awakening'),
(4, 'Ocarina of time'),
(5, 'Twilight Princess'),
(6, 'Skyward Sword');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `juegos_favoritos`
--

CREATE TABLE IF NOT EXISTS `juegos_favoritos` (
  `id_usuario` int(11) NOT NULL,
  `id_juego` int(11) NOT NULL,
  KEY `id_usuario` (`id_usuario`),
  KEY `id_juego` (`id_juego`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `juegos_favoritos`
--

INSERT INTO `juegos_favoritos` (`id_usuario`, `id_juego`) VALUES
(1, 1),
(1, 4),
(1, 6),
(2, 4),
(2, 3),
(2, 2),
(3, 5),
(3, 1),
(4, 4),
(4, 2),
(5, 4),
(5, 2),
(5, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personajes`
--

CREATE TABLE IF NOT EXISTS `personajes` (
  `id_personaje` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  PRIMARY KEY (`id_personaje`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Volcado de datos para la tabla `personajes`
--

INSERT INTO `personajes` (`id_personaje`, `nombre`) VALUES
(1, 'Link'),
(2, 'Zelda'),
(3, 'Ganondorf'),
(4, 'Tingle');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personajes_favoritos`
--

CREATE TABLE IF NOT EXISTS `personajes_favoritos` (
  `id_usuario` int(11) NOT NULL,
  `id_personaje` int(11) NOT NULL,
  KEY `id_usuario` (`id_usuario`),
  KEY `id_personaje` (`id_personaje`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `personajes_favoritos`
--

INSERT INTO `personajes_favoritos` (`id_usuario`, `id_personaje`) VALUES
(1, 1),
(1, 2),
(2, 1),
(2, 4),
(3, 3),
(3, 1),
(4, 1),
(5, 1),
(5, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) NOT NULL,
  `edad` int(11) NOT NULL,
  `zelda` enum('Si','No') NOT NULL,
  `id_consola` int(11) NOT NULL,
  PRIMARY KEY (`id_usuario`),
  KEY `id_consola` (`id_consola`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id_usuario`, `nombre`, `edad`, `zelda`, `id_consola`) VALUES
(1, 'Fernando', 30, 'Si', 4),
(2, 'Miguel', 32, 'No', 5),
(3, 'Juan Antonio', 26, 'Si', 2),
(4, 'Fernando Menacho', 25, 'No', 2),
(5, 'David', 21, 'Si', 3);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `juegos_favoritos`
--
ALTER TABLE `juegos_favoritos`
  ADD CONSTRAINT `juegos_favoritos_ibfk_2` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `juegos_favoritos_ibfk_1` FOREIGN KEY (`id_juego`) REFERENCES `juegos` (`id_juego`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `personajes_favoritos`
--
ALTER TABLE `personajes_favoritos`
  ADD CONSTRAINT `personajes_favoritos_ibfk_2` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `personajes_favoritos_ibfk_1` FOREIGN KEY (`id_personaje`) REFERENCES `personajes` (`id_personaje`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`id_consola`) REFERENCES `consolas` (`id_consola`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
