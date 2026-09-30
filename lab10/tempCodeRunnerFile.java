String scoreText = "Score: " + score;
            int textWidth = g.getFontMetrics().stringWidth(scoreText);
            g.drawString(scoreText, getWidth() - textWidth - 20, 25);
