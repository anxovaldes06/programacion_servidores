<?php
$nombre = $_POST['nombre'] ?? '';
$apellidos = $_POST['apellidos'] ?? '';
$edad = $_POST['edad'] ?? '';

$nombre = htmlspecialchars($nombre, ENT_QUOTES, 'UTF-8');
$apellidos = htmlspecialchars($apellidos, ENT_QUOTES, 'UTF-8');
$edad = htmlspecialchars($edad, ENT_QUOTES, 'UTF-8');

if ($nombre !== '' || $apellidos !== '' || $edad !== '') {
    echo "Me llamo $nombre $apellidos y tengo $edad anios";
} else {
    echo "No se recibieron datos del formulario.";
}
?>
